import React from 'react';
import './Home.css';
import dogImage from "../../assets/dog.jpg"; // You'll need to add this image
import { useEffect } from 'react';
import { useNavigate , useLocation } from 'react-router-dom';

const Home = () => {
  const navigate = useNavigate();

  const location = useLocation();

  useEffect(() => {
    if (location.hash) {
      const element = document.getElementById(location.hash.substring(1));
      if (element) {
        element.scrollIntoView({ behavior: "smooth" });
      }
    }
  }, [location]);


  return (
    <div className="home-container">
      <div className="hero-section">
        <div className="hero-content">
          <h1 className="hero-title">Ready to Adopt!</h1>
          <div className="underline"></div>
          <p className="hero-text">
          Welcome to our pet adoption platform, where loving homes meet adorable pets. Discover your perfect companion among our rescued animals and give them a second chance at life. Join our community, make a difference, and experience the joy of pet adoption today!
          </p>
          <button className="cta-button" onClick={() => navigate('/pet-listing')}>
            View Puppies <span className="arrow">→</span>
          </button>
        </div>
        
        <div className="hero-image-container">
          <img src={dogImage} alt="Adorable dog" className="hero-image" />
          
        </div>
      </div>
      {/* <div className="wave-bottom">  </div> */}
    </div>
  );
};

export default Home;




