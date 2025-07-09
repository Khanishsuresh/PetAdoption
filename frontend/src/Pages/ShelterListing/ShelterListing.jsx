import React, { useEffect, useState } from 'react';
import './ShelterListing.css';
import { useNavigate } from 'react-router-dom';

const ShelterListing = () => {
  const navigation = useNavigate();
  
  const [shelters, setShelters] = useState([]);
  const [loading, setLoading] = useState(true);
  const [error, setError] = useState('');

  useEffect(() => {
    const fetchShelters = async () => {
      setLoading(true);
      setError('');
      try {
        const response = await fetch('http://localhost:8080/api/shelters');
        if (!response.ok) throw new Error('Failed to fetch shelters');
        const data = await response.json();
        setShelters(data);
      } catch {
        setError('Could not load shelters.');
      } finally {
        setLoading(false);
      }
    };
    
    fetchShelters();
  }, []);

  if (loading) return <div className="loading">Loading shelters...</div>;
  if (error) return <div className="error">{error}</div>;

  return (
    <div className="shelter-listing-container">
      <h1>Animal Shelters</h1>
      
      <div className="shelters-grid">
        {shelters && shelters.length > 0 ? (
          shelters.map((shelter) => (
            <div key={shelter.id} className="shelter-card" onClick={() => navigation(`/shelter-details/${shelter.id}`)}>
              <div className="shelter-card-content">
                <h2 className="shelter-name-info">{shelter.name}</h2>
                <div className="shelter-location">
                  <i className="location-icon">📍</i>
                  {shelter.location}
                </div>
              </div>
            </div>
          ))
        ) : (
          <p>No shelters available.</p>
        )}
      </div>
    </div>
  );
};

export default ShelterListing;