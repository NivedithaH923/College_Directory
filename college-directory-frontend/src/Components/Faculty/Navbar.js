import React, { useState } from 'react';
import './Navbar.css';
import { useNavigate } from 'react-router-dom';

const Navbar = () => {
    const navigate = useNavigate();
    const [showModal, setShowModal] = useState(false);
    const [sidebarData, setSidebarData] = useState({
        name: 'Prasad',
        email: 'prasad@gmail.com',
        phone: '8745787679',
        course: 'Data Structures',
        officeHours: '9:00AM-5:00PM',
    });

    const handleLogout = () => {
        navigate('/');
    };

    const handleUpdateClick = () => {
        setShowModal(true);
    };

    const handleModalClose = () => {
        setShowModal(false);
    };

    const handleFormSubmit = (e) => {
        e.preventDefault();
        setSidebarData({
            name: e.target.name.value,
            email: e.target.email.value,
            phone: e.target.phone.value,
            course: e.target.course.value,
            officeHours: e.target.officeHours.value,
        });
        setShowModal(false);
    };

    return (
        <div className="navigation-container">
            <div className="navbar">
                <h1 className="navbar-title">Faculty Dashboard</h1>
                <button className="logout-button" onClick={handleLogout}>Logout</button>
            </div>

            <div className="sidebar">
                {/* Updated img tag to display the image */}
                <img 
                    src="/Images/prasad.jpg" // Reference to the image in the public folder
                    alt="Profile" 
                    style={{ height: "100px", width: "100px", borderRadius: "50px", marginLeft: "100px", marginTop: "40px" }} 
                />
                <div className="student-details">
                    <div>Name: {sidebarData.name}</div>
                    <div>Email: {sidebarData.email}</div>
                    <div>Phone No: {sidebarData.phone}</div>
                    <div>Course: {sidebarData.course}</div>
                    <div>Office hours: {sidebarData.officeHours}</div>
                </div>
                <button className="update-button" onClick={handleUpdateClick}>Update</button>
            </div>

            {showModal && (
                <div className="modal-overlay">
                    <div className="modal">  
                        <form onSubmit={handleFormSubmit}>
                            <h2 style={{textAlign:"center"}}>Update Details</h2>
                            <label>
                                Name: <input type="text" name="name" defaultValue={sidebarData.name} required />
                            </label>
                            <label>
                                Email: <input type="email" name="email" defaultValue={sidebarData.email} required />
                            </label>
                            <label>
                                Phone: <input type="tel" name="phone" defaultValue={sidebarData.phone} required />
                            </label>
                            <label>
                                Course: <input type="text" name="course" defaultValue={sidebarData.course} required />
                            </label>
                            <label>
                                Office Hours: <input type="text" name="officeHours" defaultValue={sidebarData.officeHours} required />
                            </label>
                            <button type="submit" style={{backgroundColor:"green"}}>Save</button>
                            <button type="button" style={{backgroundColor:"blue"}} onClick={handleModalClose}>Cancel</button>
                        </form>
                    </div>
                </div>
            )}
        </div>
    );
};

export default Navbar;
