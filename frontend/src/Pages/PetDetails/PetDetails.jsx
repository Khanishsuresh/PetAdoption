import React, { useEffect, useState } from 'react';
import './PetDetails.css';
import { Link, useParams } from 'react-router-dom';
import puppyImage from '../../assets/puppy.jpg';

const PetDetails = () => {
  const { id } = useParams();
  
  const [pet, setPet] = useState(null);
  const [loading, setLoading] = useState(true);
  const [error, setError] = useState('');

  useEffect(() => {
    if (!id) {
      setError('No pet ID provided.');
      setLoading(false);
      return;
    }
    const fetchPet = async () => {
      setLoading(true);
      setError('');
      try {
        const response = await fetch(`http://localhost:8080/api/pets/${id}`);
        if (!response.ok) throw new Error('Failed to fetch pet details');
        const data = await response.json();
        setPet(data);
      } catch {
        setError('Could not load pet details.');
      } finally {
        setLoading(false);
      }
    };
    fetchPet();
  }, [id]);

  if (loading) return <div>Loading...</div>;
  if (error) return <div>{error}</div>;
  if (!pet) return <div>No pet found.</div>;

  return (
    <div className="pet-details-container">
      <div className="pet-details-card">
        <div className="pet-image-container">
          <img
            src={pet.image || puppyImage}
            alt={pet.name}
            className="pet-image"
          />
        </div>
        <div className="pet-info">
          <h1 className="pet-name">{pet.name}</h1>
          <div className="pet-details">
            <p><strong>Breed:</strong> {pet.breed}</p>
            <p><strong>Age:</strong> {pet.age}</p>
          </div>
          <div className="pet-description">
            <h2>About {pet.name}</h2>
            <p>{pet.description}</p>
          </div>
          <Link to={`/pet-enquiry/${id}`}>
            <button className="enquire-button">
              Enquire Now
            </button>
          </Link>
        </div>
      </div>
    </div>
  );
};

export default PetDetails;