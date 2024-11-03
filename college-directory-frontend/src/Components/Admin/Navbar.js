import React from 'react';
import './Navbar.css';
import { useNavigate } from 'react-router-dom';

const Navbar = ({ onViewChange }) => {
  const navigate = useNavigate();
  const handleLogout = () => {
    navigate('/');
  };

  return (
    <div className="navigation-container">
      {/* Top Navbar */}
      <div className="navbar">
        <h1 className="navbar-title" onClick={() => onViewChange('admin')}>Admin Dashboard</h1>
        <div className="faculty" onClick={() => onViewChange('faculty')}>Faculty</div>
        <div className="student" onClick={() => onViewChange('student')}>Student</div>
        <div className="logout-btn" onClick={handleLogout}>Logout</div>
      </div>

      {/* Left Sidebar */}
      <div className="sidebar">
        <img
          src={`${process.env.PUBLIC_URL}/Images/basavraj.jpg`}
          alt="Basavraj"
          style={{
            height: "100px",
            width: "100px",
            borderRadius: "50px",
            marginLeft: "100px",
            marginTop: "40px"
          }}
        />
        <div className="student-details">
          <div>Name: Basavraj</div>
          <div>Email: basa@gmail.com</div>
          <div>Phone No: 875410445</div>
        </div>
      </div>

      {/* Main Content Area */}
      <div className="content">
        {/* This is where the main page content will go */}
      </div>
    </div>
  );
};

export default Navbar;
