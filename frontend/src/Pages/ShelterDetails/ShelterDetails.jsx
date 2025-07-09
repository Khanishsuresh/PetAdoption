import React, { useEffect, useState } from 'react';
import './ShelterDetails.css';
import { useParams } from 'react-router-dom';
import PetCard from '../PetListing/PetCard';
import puppyImage from "../../assets/puppy.jpg";

const ShelterDetails = () => {
  const { id } = useParams();
  
  const [shelter, setShelter] = useState(null);
  const [loading, setLoading] = useState(true);
  const [error, setError] = useState('');

  useEffect(() => {
    if (!id) {
      setError('No shelter ID provided.');
      setLoading(false);
      return;
    }
    
    const fetchShelter = async () => {
      setLoading(true);
      setError('');
      try {
        const response = await fetch(`http://localhost:8080/api/shelters/${id}`);
        if (!response.ok) throw new Error('Failed to fetch shelter details');
        const data = await response.json();
        setShelter(data);
      } catch {
        setError('Could not load shelter details.');
      } finally {
        setLoading(false);
      }
    };
    
    fetchShelter();
  }, [id]);

  if (loading) return <div className="loading">Loading shelter details...</div>;
  if (error) return <div className="error">{error}</div>;
  if (!shelter) return <div className="error">No shelter found.</div>;

  return (
    <div className="shelter-details-container">
      <div className="shelter-header">
        <div className="shelter-main-info">
          <h1 className="shelter-name">{shelter.name}</h1>
          <div className="shelter-location-info">
            <span className="location-icon">📍</span>
            <span className="location-text">{shelter.location}</span>
          </div>
        </div>
        
        {/* <div className="shelter-contact-details">
          <div className="contact-item">
            <strong>Email:</strong> {shelter.contactEmail}
          </div>
          <div className="contact-item">
            <strong>Phone:</strong> {shelter.contactPhone}
          </div>
          <div className="contact-item">
            <strong>Operating Hours:</strong> {shelter.operatingHours}
          </div>
        </div> */}
      </div>

      <div className="shelter-content-placeholder">
        {/* This section is left for you to develop */}
        <h2>Pets Available</h2>

        <div className="shelter-pet-listing">
            {shelter.pets && shelter.pets.length > 0 ? (
              shelter.pets.map((pet, index) => (
                <PetCard 
                  key={pet.id || index} 
                  id={pet.id}
                  img={pet.image || puppyImage} 
                  name={pet.name} 
                  breed={pet.breed} 
                  description={pet.description}
                />
              ))
            ) : (
              <p>No pets available at this shelter.</p>
            )}
        </div>
      </div>
    </div>
  );
};

export default ShelterDetails;  