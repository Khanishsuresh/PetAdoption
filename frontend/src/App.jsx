import { BrowserRouter as Router, Route, Routes } from 'react-router-dom';

import './App.css';
import Home from './Pages/Home/Home.jsx';
import Navbar from './Components/Navbar/Navbar.jsx';
import Service from './Pages/Service/Service.jsx';
import TestimonialsPage from './Pages/Testimonials/Testimonials.jsx';
import Footer from './Components/Footer/Footer.jsx';
import PetListing from './Pages/PetListing/PetListing.jsx';
import PetDetails from './Pages/PetDetails/PetDetails.jsx';
import PetEnquiryForm from './Pages/PetEnquiry/PetEnquiryForm.jsx';
import UserEnquiriesList from './Pages/EnquiryList/UserEnquiryList.jsx';
import ShelterListing from './Pages/ShelterListing/ShelterListing.jsx';
import ShelterDetails from './Pages/ShelterDetails/ShelterDetails.jsx';

function App() {
  return (
    <Router>
      <Navbar />
      <Routes>
        <Route path="/" element={
          <>
          <Home />
          <Service />
          <TestimonialsPage />
          {/* <ShelterListing /> */}
          </>
        } />
        {/* <Route path="/service" element={<Service />} />
        <Route path="/testimonials" element={<TestimonialsPage />} /> */}
        <Route path="/pet-listing" element={<PetListing />} />
        <Route path="/pet-details/:id" element={<PetDetails />} />
        <Route path="/pet-enquiry/:id" element={<PetEnquiryForm />} />
        <Route path="/user-enquiries" element={<UserEnquiriesList />} />
        <Route path="/shelter-listing" element={<ShelterListing />} />
        <Route path="/shelter-details/:id" element={<ShelterDetails />} />
      </Routes>
      <Footer />
    </Router>
  );
}

export default App;
