import React, { useState } from 'react';
import { useParams, useNavigate } from 'react-router-dom';
import './PetEnquiryForm.css';

const PetEnquiryForm = ({ petId }) => {
  const { id } = useParams();
  const navigate = useNavigate();
  
  const [formData, setFormData] = useState({
    name: '',
    email: '',
    message: '',
    petId: petId || id || ''
  });
  
  const [loading, setLoading] = useState(false);
  const [error, setError] = useState('');
  const [success, setSuccess] = useState(false);

  const handleChange = (e) => {
    const { name, value } = e.target;
    setFormData(prevState => ({
      ...prevState,
      [name]: value
    }));
  };

  const handleSubmit = async (e) => {
    e.preventDefault();
    setLoading(true);
    setError('');
    setSuccess(false);
    
    try {
      // Prepare the data in the format expected by the backend
      const inquiryData = {
        name: formData.name,
        email: formData.email,
        message: formData.message,
        pet: {
          id: parseInt(formData.petId) // Convert to number as backend expects long
        }
      };
      
      const response = await fetch('http://localhost:8080/api/inquiries', {
        method: 'POST',
        headers: {
          'Content-Type': 'application/json',
        },
        body: JSON.stringify(inquiryData),
      });
      
      if (!response.ok) {
        const errorText = await response.text();
        throw new Error(`Failed to submit enquiry: ${errorText}`);
      }
      
      const result = await response.json();
      console.log('Enquiry Submitted Successfully:', result);
      
      setSuccess(true);
      
      // Reset form after successful submission
      setFormData({
        name: '',
        email: '',
        message: '',
        petId: petId || id || ''
      });
      
      // Redirect to enquiry list after 2 seconds
      setTimeout(() => {
        navigate('/user-enquiries');
      }, 2000);
      
    } catch (error) {
      console.error('Error submitting enquiry:', error);
      setError(`Failed to submit enquiry: ${error.message}`);
    } finally {
      setLoading(false);
    }
  };

  return (
    <div className="enquiry-form-container">
      <form onSubmit={handleSubmit} className="enquiry-form">
        <h2>Pet Adoption Enquiry</h2>
        
        {error && (
          <div className="error-message" style={{ color: 'red', marginBottom: '1rem', padding: '0.5rem', border: '1px solid red', borderRadius: '4px' }}>
            {error}
          </div>
        )}
        
        {success && (
          <div className="success-message" style={{ color: 'green', marginBottom: '1rem', padding: '0.5rem', border: '1px solid green', borderRadius: '4px' }}>
            Enquiry submitted successfully! Redirecting to your enquiries...
          </div>
        )}
        
        <div className="form-group">
          <label htmlFor="name">Full Name</label>
          <input
            type="text"
            id="name"
            name="name"
            value={formData.name}
            onChange={handleChange}
            placeholder="Enter your full name"
            required
          />
        </div>
        
        <div className="form-group">
          <label htmlFor="email">Email Address</label>
          <input
            type="email"
            id="email"
            name="email"
            value={formData.email}
            onChange={handleChange}
            placeholder="Enter your email"
            required
          />
        </div>
        
        <div className="form-group">
          <label htmlFor="message">Your Message</label>
          <textarea
            id="message"
            name="message"
            value={formData.message}
            onChange={handleChange}
            placeholder="Tell us why you're interested in this pet"
            rows="4"
            required
          ></textarea>
        </div>
        
        <div className="form-group">
          <label htmlFor="petId">Pet ID</label>
          <input
            type="text"
            id="petId"
            name="petId"
            value={formData.petId}
            onChange={handleChange}
            readOnly
            disabled
            className="pet-id-input"
          />
        </div>
        
        <button type="submit" className="submit-button" disabled={loading}>
          {loading ? 'Submitting...' : 'Submit Enquiry'}
        </button>
      </form>
    </div>
  );
};

export default PetEnquiryForm;