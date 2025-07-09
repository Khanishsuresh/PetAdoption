import React from 'react';
import { Link, useLocation } from 'react-router-dom';
import './Navbar.css';
import logo from '../../assets/logo.jpg';

const Navbar = () => {
  const location = useLocation(); // Get the current route

  return (
    <nav className="navbar">
      <div className="navbar-container">
        {/* Logo Section */}
        <Link to="/" className="logo-container">
          <img src={logo} alt="Petadopt Logo" className="logo" />
          <span className="logo-text">Petadopt</span>
        </Link>

        {/* Navigation Links */}
        <ul className="nav-menu">
          <li className={`nav-item ${location.pathname === '/' ? 'active' : ''}`}>
            <Link to="/" className="nav-link">
              <span className="paw-icon">🐾</span> Home
            </Link>
          </li>

          <li className={`nav-item ${location.pathname === '/pet-listing' ? 'active' : ''}`}>
            <Link to="/pet-listing" className="nav-link">Pets</Link>
          </li>

          <li className={`nav-item ${location.pathname === '/shelter-listing' ? 'active' : ''}`}>
            <Link to="/shelter-listing" className="nav-link">Shelter</Link>
          </li>

          <li className={`nav-item ${location.pathname === '/user-enquiries' ? 'active' : ''}`}>
            <Link to="/user-enquiries" className="nav-link">My Enquiries</Link>
          </li>

          <li className={`nav-item ${location.hash === '#services' ? 'active' : ''}`}>
            <a href="/#services" className="nav-link">Services</a>
          </li>

          <li className={`nav-item ${location.hash === '#testimonials' ? 'active' : ''}`}>
            <a href="/#testimonials" className="nav-link">Testimonials</a>
          </li>

          <li className={`nav-item ${location.hash === '#footer' ? 'active' : ''}`}>
            <a href="/#footer" className="nav-link">Contact</a>
          </li>
        </ul>

        {/* Contact Info */}
        <div className="contact-info">
          <div className="phone-icon">📞</div>
          <div className="phone-details">
            <div className="phone-number">123-456-7890</div>
            <div className="call-text">Call us today</div>
          </div>
        </div>

        {/* Mobile Menu Icon */}
        <div className="hamburger">
          <span className="bar"></span>
          <span className="bar"></span>
          <span className="bar"></span>
        </div>
      </div>
    </nav>
  );
};

export default Navbar;
