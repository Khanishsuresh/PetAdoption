import React from 'react';
import './Footer.css';

const Footer = () => {
  return (
    <footer className="petadopt-footer" id='footer'>
      <div className="footer-content">
        <div className="footer-section about">
          <h3>PetAdopt</h3>
          <p>Connecting loving homes with furry friends. Our mission is to provide compassionate animal rescue and adoption services.</p>
          <div className="social-icons">
            <a href="#" className="social-icon">Facebook</a>
            <a href="#" className="social-icon">Instagram</a>
            <a href="#" className="social-icon">Twitter</a>
          </div>
        </div>

        <div className="footer-section links">
          <h4>Quick Links</h4>
          <ul>
            <li><a href="#">Adopt a Pet</a></li>
            <li><a href="#">Available Animals</a></li>
            <li><a href="#">Adoption Process</a></li>
            <li><a href="#">Success Stories</a></li>
          </ul>
        </div>

        <div className="footer-section contact">
          <h4>Contact Us</h4>
          <p>📍 123 Furry Friend Lane, Pawville, CA 94000</p>
          <p>📞 (555) 123-PETS</p>
          <p>✉️ support@petadopt.org</p>
        </div>

        <div className="footer-section newsletter">
          <h4>Stay Updated</h4>
          <p>Subscribe to our newsletter for adoption updates and pet care tips!</p>
          <form className="newsletter-form">
            <input 
              type="email" 
              placeholder="Enter your email" 
              required 
            />
            <button type="submit">Subscribe</button>
          </form>
        </div>
      </div>

      <div className="footer-bottom">
        <p>&copy; 2024 PetAdopt. All Rights Reserved.</p>
        <div className="footer-bottom-links">
          <a href="#">Privacy Policy</a>
          <a href="#">Terms of Service</a>
        </div>
      </div>
    </footer>
  );
};

export default Footer;