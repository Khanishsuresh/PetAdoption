import React, { useEffect , useState } from 'react';
import './UserEnquiryList.css';

const UserEnquiriesList = () => {
  const [enquiries, setEnquiries] = useState([]);
  const [loading, setLoading] = useState(true);
  const [error, setError] = useState('');
  const [petDetails, setPetDetails] = useState({});

  useEffect(() => {
    const fetchData = async () => {
      setLoading(true);
      setError('');
      try {
        // Fetch all pets with IDs first
        const petsResponse = await fetch('http://localhost:8080/api/pets/allWithIds');
        if (!petsResponse.ok) throw new Error('Failed to fetch pets');
        const petsData = await petsResponse.json();
        // console.log(petsData);
        
        // Create a map of pet ID to pet details for quick lookup
        const petDetailsMap = {};
        petsData.forEach(pet => {
          petDetailsMap[pet.id] = pet;
          // console.log(petDetailsMap[pet.id]);
        });
        setPetDetails(petDetailsMap);
        
        // Fetch enquiries
        const response = await fetch('http://localhost:8080/api/inquiries');
        if (!response.ok) throw new Error('Failed to fetch enquiries');
        const data = await response.json();
        setEnquiries(data);
      } catch (error) {
        console.error('Error fetching data:', error);
        setError('Could not load data.');
      } finally {
        setLoading(false);
      }
    };
    
    fetchData();
  }, []);

  const handleDeleteEnquiry = async (enquiryId) => {
    const confirmDelete = window.confirm('Are you sure you want to delete this enquiry?');
    
    if (confirmDelete) {
      try {
        const response = await fetch(`http://localhost:8080/api/inquiries/${enquiryId}`, {
          method: 'DELETE',
        });
        
        if (!response.ok) throw new Error('Failed to delete enquiry');
        
        // Remove from local state after successful deletion
        const updatedEnquiries = enquiries.filter(enquiry => enquiry.id !== enquiryId);
        setEnquiries(updatedEnquiries);
        
        console.log(`Successfully deleted enquiry with ID: ${enquiryId}`);
      } catch (error) {
        console.error('Error deleting enquiry:', error);
        alert('Failed to delete enquiry. Please try again.');
      }
    }
  };

  if (loading) return <div className="loading">Loading enquiries...</div>;
  if (error) return <div className="error">{error}</div>;

  return (
    <div className="user-enquiries-container">
      <h2>My Pet Adoption Enquiries</h2>
      
      {enquiries.length === 0 ? (
        <div className="no-enquiries">
          <p>You haven't made any enquiries yet.</p>
        </div>
      ) : (
        <div className="enquiries-list">
          {enquiries.map((enquiry) => (
            <div key={enquiry.id} className="enquiry-card">
              <div className="enquiry-header">
                <span className="enquiry-id">Enquiry ID: {enquiry.id}</span>
                <span className="enquiry-date">
                  {new Date(enquiry.inqueryDateTime || enquiry.createdAt || Date.now()).toLocaleDateString()}
                </span>
              </div>
              <div className="enquiry-details">
                <p><strong>Pet ID:</strong> {enquiry.pet?.id || 'N/A'}</p>
                <p><strong>Pet Name:</strong> {petDetails[enquiry.pet?.id]?.name || enquiry.pet?.name || 'N/A'}</p>
                <p><strong>Pet Breed:</strong> {petDetails[enquiry.pet?.id]?.breed || 'N/A'}</p>
                <p><strong>Pet Shelter ID:</strong> {petDetails[enquiry.pet?.id]?.shelterId || 'N/A'}</p>
                <p><strong>Name:</strong> {enquiry.name}</p>
                <p><strong>Email:</strong> {enquiry.email}</p>
                <p><strong>Message:</strong> {enquiry.message}</p>
              </div>
              <div className="enquiry-actions">
                <button
                  className="delete-button"
                  onClick={() => handleDeleteEnquiry(enquiry.id)}
                >
                  Delete Enquiry
                </button>
              </div>
            </div>
          ))}
        </div>
      )}
    </div>
  );
};

export default UserEnquiriesList;