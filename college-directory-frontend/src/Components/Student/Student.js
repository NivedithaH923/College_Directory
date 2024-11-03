import React, { useState } from 'react';
import { useNavigate } from 'react-router-dom';
import Navbar from '../Navbar/Navbar';
import './Student.css';

const Student = () => {
  const navigate = useNavigate();

  const [showGrade, setShowGrade] = useState(false);
  const [showAttendance, setShowAttendance] = useState(false);
  const [searchTerm, setSearchTerm] = useState('');
  const [departmentFilter, setDepartmentFilter] = useState('');
  const [yearFilter, setYearFilter] = useState('');

  const handleCardClick = (card) => {
    if (card === 'courses') {
      navigate('/courses');
    } else if (card === 'grades') {
      setShowGrade(!showGrade);
    } else if (card === 'attendance') {
      setShowAttendance(!showAttendance);
    }
  };

  // Sample data for the table
  const studentData = [
    { name: 'Amith', department: 'Computer Science', year: 'Senior' },
    { name: 'Niveditha', department: 'Information Science', year: 'Junior' },
    { name: 'Chethana', department: 'AIML', year: 'Freshman' },
    { name: 'Ragu', department: 'Electronics', year: 'Sophomore' },
    { name: 'Prasad', department: 'Robotics', year: 'Senior' },
  ];

  // Function to filter student data based on search and selected filters
  const filteredStudents = studentData.filter((student) => {
    const matchesSearch = student.name.toLowerCase().includes(searchTerm.toLowerCase());
    const matchesDepartment = departmentFilter ? student.department === departmentFilter : true;
    const matchesYear = yearFilter ? student.year === yearFilter : true;

    return matchesSearch && matchesDepartment && matchesYear;
  });

  return (
    <div>
      <Navbar />
      <div className="student-content">
        <div className="card-container">
          <div className="card" onClick={() => handleCardClick('courses')}>
            Courses
          </div>
          <div className="card" onClick={() => handleCardClick('grades')} style={{ display: 'flex', flexDirection: 'column', alignItems: 'center' }}>
            <div>Grades</div>
            {showGrade && <div style={{ fontWeight: 'bold', fontSize: '24px' }}>A</div>}
          </div>
          <div className="card" onClick={() => handleCardClick('attendance')} style={{ display: 'flex', flexDirection: 'column', alignItems: 'center' }}>
            <div>Attendance</div>
            {showAttendance && <div style={{ fontWeight: 'bold', fontSize: '24px' }}>90%</div>}
          </div>
        </div>
        <div className="filters">
          <div className="search-container">
            <i className="fas fa-search search-icon"></i>
            <input
              type="text"
              placeholder="Search..."
              className="search-bar"
              value={searchTerm}
              onChange={(e) => setSearchTerm(e.target.value)}
            />
          </div>
          <select className="filter-dropdown" onChange={(e) => setDepartmentFilter(e.target.value)}>
            <option value="">Filter by Department</option>
            <option value="Computer Science">Computer Science</option>
            <option value="Information Science">Information Science</option>
            <option value="AIML">AIML</option>
            <option value="Electronics">Electronics</option>
            <option value="Robotics">Robotics</option>
          </select>
          <select className="filter-dropdown" onChange={(e) => setYearFilter(e.target.value)}>
            <option value="">Sort by</option>
            <option value="Freshman">FRESHERS</option>
            <option value="Sophomore">SOPHOMORE</option>
            <option value="Junior">JUNIOR</option>
            <option value="Senior">SENIOR</option>
          </select>
        </div>

        {/* Table to display filtered student data */}
        <div className="student-table">
          <table>
            <thead>
              <tr>
                <th>Name</th>
                <th>Department</th>
                <th>Year</th>
              </tr>
            </thead>
            <tbody>
              {filteredStudents.map((student, index) => (
                <tr key={index}>
                  <td>{student.name}</td>
                  <td>{student.department}</td>
                  <td>{student.year}</td>
                </tr>
              ))}
            </tbody>
          </table>
        </div>
      </div>
    </div>
  );
};

export default Student;
