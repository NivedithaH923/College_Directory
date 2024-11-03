import React, { useState, useEffect } from 'react';
import Navbar from './Navbar';
import { PieChart, Pie, XAxis, YAxis, CartesianGrid, Tooltip, BarChart, Bar, Legend } from 'recharts';
import './Admin.css';

const Admin = () => {
  const [view, setView] = useState('');
  const [isModalOpen, setIsModalOpen] = useState(false);
  const [isStudentUpdate, setIsStudentUpdate] = useState(false);
  const [selectedData, setSelectedData] = useState(null);
  const [isAdding, setIsAdding] = useState(false);

  const initialStudentData = JSON.parse(localStorage.getItem('studentData')) || [
    { slNo: 1, name: 'Niveditha', email: 'nivi@example.com', phone: '56564343445', year: 'Sophomore' },
    { slNo: 2, name: 'Bharani', email: 'bha@example.com', phone: '98700654321', year: 'Junior' },
    { slNo: 3, name: 'Chethana', email: 'chethu@example.com', phone: '4789580021', year: 'Senior' },
    { slNo: 4, name: 'Nanadish', email: 'nan@example.com', phone: '89650023147', year: ' Fresher' },
  ];

  const initialFacultyData = JSON.parse(localStorage.getItem('facultyData')) || [
    { slNo: 1, name: 'Prasad', email: 'prasad@example.com', phone: '8754621975', course: 'Data Structure', officeHours: '10am - 12pm' },
    { slNo: 2, name: 'Nayana', email: 'nayana@example.com', phone: '9875600676', course: 'Cloud Computing', officeHours: '1pm - 3pm' },
    { slNo: 3, name: 'Raj', email: 'raj@example.com', phone: '7896021435', course: 'Operating System', officeHours: '2pm - 3pm' },
    { slNo: 4, name: 'Shastri', email: 'shastri@example.com', phone: '9875600676', course: 'AIML', officeHours: '9am - 10pm' },
  ];

  const [studentData, setStudentData] = useState(initialStudentData);
  const [facultyData, setFacultyData] = useState(initialFacultyData);

  useEffect(() => {
    localStorage.setItem('studentData', JSON.stringify(studentData));
  }, [studentData]);

  useEffect(() => {
    localStorage.setItem('facultyData', JSON.stringify(facultyData));
  }, [facultyData]);

  const handleViewChange = (viewType) => setView(viewType);

  const handleDelete = (type, slNo) => {
    if (window.confirm("Are you sure you want to delete this entry?")) {
      if (type === 'student') {
        setStudentData((prevData) => prevData.filter(student => student.slNo !== slNo));
      } else {
        setFacultyData((prevData) => prevData.filter(faculty => faculty.slNo !== slNo));
      }
    }
  };

  const handleUpdate = (type, data) => {
    setIsAdding(false);
    setIsStudentUpdate(type === 'student');
    setSelectedData(data);
    setIsModalOpen(true);
  };

  const handleAdd = (type) => {
    setIsAdding(true);
    setIsStudentUpdate(type === 'student');
    setSelectedData({
      slNo: Math.max(...(type === 'student' ? studentData : facultyData).map(d => d.slNo)) + 1,
      name: '',
      email: '',
      phone: '',
      year: '',
      course: '',
      officeHours: '',
    });
    setIsModalOpen(true);
  };

  const handleModalClose = () => {
    setIsModalOpen(false);
    setSelectedData(null);
  };

  const handleInputChange = (e) => {
    const { name, value } = e.target;
    setSelectedData((prevData) => ({ ...prevData, [name]: value }));
  };

  const handleModalSave = () => {
    if (isAdding) {
      if (isStudentUpdate) {
        setStudentData((prevData) => [...prevData, selectedData]);
      } else {
        setFacultyData((prevData) => [...prevData, selectedData]);
      }
    } else {
      if (isStudentUpdate) {
        setStudentData((prevData) =>
          prevData.map((student) => (student.slNo === selectedData.slNo ? selectedData : student))
        );
      } else {
        setFacultyData((prevData) =>
          prevData.map((faculty) => (faculty.slNo === selectedData.slNo ? selectedData : faculty))
        );
      }
    }
    handleModalClose();
  };

  // Prepare graph data
  const studentCountByYear = studentData.reduce((acc, student) => {
    const year = student.year;
    acc[year] = (acc[year] || 0) + 1;
    return acc;
  }, {});

  const facultyCountByCourse = facultyData.reduce((acc, faculty) => {
    const course = faculty.course;
    acc[course] = (acc[course] || 0) + 1;
    return acc;
  }, {});

  const studentGraphData = Object.entries(studentCountByYear).map(([year, count]) => ({ year, count }));
  const facultyGraphData = Object.entries(facultyCountByCourse).map(([course, count]) => ({ course, count }));

  // Define styles
  const formStyle = {
    display: 'flex',
    flexDirection: 'column',
    gap: '10px',
    padding: '20px',
    background: '#fff',
    border: '1px solid #ccc',
    borderRadius: '5px',
  };

  const headerStyle = {
    margin: 0,
  };

  const inputStyle = {
    padding: '10px',
    border: '1px solid #ccc',
    borderRadius: '5px',
  };

  const buttonStyle = {
    padding: '10px',
    backgroundColor: '#28a745',
    color: 'white',
    border: 'none',
    borderRadius: '5px',
    cursor: 'pointer',
  };

  return (
    <div>
      <Navbar onViewChange={handleViewChange} />
      <div className="content-area">
        {/* Graphs Section, only show if not viewing student or faculty */}
        {view !== 'student' && view !== 'faculty' && (
          <>
            <h2>Graphs Overview</h2>
            <div className="graphs-container">
              <div className="graph">
                <h3>Number of Students by Year</h3>
                <BarChart width={400} height={300} data={studentGraphData}>
                  <XAxis dataKey="year" />
                  <YAxis />
                  <Tooltip />
                  <Bar dataKey="count" fill="#8884d8" />
                </BarChart>
              </div>
              <div className="graph">
                <h3>Number of Faculty by Course</h3>
                <BarChart width={400} height={300} data={facultyGraphData}>
                  <XAxis dataKey="course" />
                  <YAxis />
                  <Tooltip />
                  <Bar dataKey="count" fill="#82ca9d" />
                </BarChart>
              </div>
            </div>
          </>
        )}

        {/* Student or Faculty View */}
        {view === 'student' && (
          <div className="table-container">
            <h2>Student Details</h2>
            <button className="add-btn" onClick={() => handleAdd('student')}>Add Student</button>
            <table className="details-table">
              <thead>
                <tr>
                  <th>Sl. No</th>
                  <th>Name</th>
                  <th>Email</th>
                  <th>Phone</th>
                  <th>Year of Studying</th>
                  <th>Action</th>
                </tr>
              </thead>
              <tbody>
                {studentData.map((student) => (
                  <tr key={student.slNo}>
                    <td>{student.slNo}</td>
                    <td>{student.name}</td>
                    <td>{student.email}</td>
                    <td>{student.phone}</td>
                    <td>{student.year}</td>
                    <td>
                      <button className="action-btn" onClick={() => handleUpdate('student', student)}>✏️</button>
                      <button className="delete-btn" onClick={() => handleDelete('student', student.slNo)}>🗑️</button>
                    </td>
                  </tr>
                ))}
              </tbody>
            </table>
          </div>
        )}

        {view === 'faculty' && (
          <div className="table-container">
            <h2>Faculty Details</h2>
            <button className="add-btn" onClick={() => handleAdd('faculty')}>Add Faculty</button>
            <table className="details-table">
              <thead>
                <tr>
                  <th>Sl. No</th>
                  <th>Name</th>
                  <th>Email</th>
                  <th>Phone</th>
                  <th>Course</th>
                  <th>Office Hours</th>
                  <th>Action</th>
                </tr>
              </thead>
              <tbody>
                {facultyData.map((faculty) => (
                  <tr key={faculty.slNo}>
                    <td>{faculty.slNo}</td>
                    <td>{faculty.name}</td>
                    <td>{faculty.email}</td>
                    <td>{faculty.phone}</td>
                    <td>{faculty.course}</td>
                    <td>{faculty.officeHours}</td>
                    <td>
                      <button className="action-btn" onClick={() => handleUpdate('faculty', faculty)}>✏️</button>
                      <button className="delete-btn" onClick={() => handleDelete('faculty', faculty.slNo)}>🗑️</button>
                    </td>
                  </tr>
                ))}
              </tbody>
            </table>
          </div>
        )}

        {/* Modal for Add/Edit */}
        {isModalOpen && (
          <div className="modal">
            
            <form style={formStyle} onSubmit={(e) => { e.preventDefault(); handleModalSave(); }}>
            <h2 style={headerStyle}>{isAdding ? `Add ${isStudentUpdate ? 'Student' : 'Faculty'}` : `Edit ${isStudentUpdate ? 'Student' : 'Faculty'}`}</h2>
              <input style={inputStyle} name="name" value={selectedData.name} onChange={handleInputChange} placeholder="Name" required />
              <input style={inputStyle} name="email" value={selectedData.email} onChange={handleInputChange} placeholder="Email" required />
              <input style={inputStyle} name="phone" value={selectedData.phone} onChange={handleInputChange} placeholder="Phone" required />
              {isStudentUpdate && (
                <input style={inputStyle} name="year" value={selectedData.year} onChange={handleInputChange} placeholder="Year of Study" required />
              )}
              {!isStudentUpdate && (
                <>
                  <input style={inputStyle} name="course" value={selectedData.course} onChange={handleInputChange} placeholder="Course" required />
                  <input style={inputStyle} name="officeHours" value={selectedData.officeHours} onChange={handleInputChange} placeholder="Office Hours" required />
                </>
              )}
              <div className='btn'>
              <button type="submit" style={{ backgroundColor: "green"}}>Save</button>
              <button type="button" style={{ backgroundColor: "green"}} onClick={handleModalClose}>Cancel</button>
              </div>
              
            </form>
          </div>
        )}
      </div>
    </div>
  );
};


export default Admin;
