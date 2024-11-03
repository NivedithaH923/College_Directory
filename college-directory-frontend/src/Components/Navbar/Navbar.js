import React from 'react';
import './Navbar.css';
import { useNavigate, Link } from 'react-router-dom';

const Navbar = () => {
    const navigate = useNavigate();

    // Manually setting studentData for the user "Nivi"
    const studentData = {
        username: 'Niveditha',
        password: '123',
        email: 'nivi@gmail.com',
        photo: 'nivi.jpg',
        phone: '56564343445',
        role: 'STUDENT'
    };

    const handleLogout = () => {
        navigate('/');
    };

    return (
        <div className="navigation-container">
            <div className="navbar">
                {/* Wrap the title in a Link for navigation */}
                <Link to="/student" className="title">
                    Student Dashboard
                </Link>
                <button className="logout-button" onClick={handleLogout}>Logout</button>
            </div>

            <div className="sidebar">
                <>
                    <img
                        src={`${process.env.PUBLIC_URL}/images/${studentData.photo}`}
                        alt="Profile"
                        style={{ height: "100px", width: "100px", borderRadius: "50px", marginLeft: "100px", marginTop: "40px" }}
                    />
                    <div className='student-details'>
                        <div>Name: {studentData.username}</div>
                        <div>Email: {studentData.email}</div>
                        <div>Phone No: {studentData.phone}</div>
                    </div>
                </>
            </div>

            <div className="content">
                {/* Additional content can be placed here */}
            </div>
        </div>
    );
};

export default Navbar;
