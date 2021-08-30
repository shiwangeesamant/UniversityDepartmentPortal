<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<%@ include file="Header.jsp" %>
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" />
<title>Menu Page</title>
<style>
ul {
    list-style-type: none;
    margin: 0;
    padding: 0;
    overflow: hidden;
    background-color: #333;
}

li {
    float: left;
}

li a, .dropbtn {
    display: inline-block;
    color: white;
    text-align: center;
    padding: 14px 16px;
    text-decoration: none;
}

li a:hover, .dropdown:hover .dropbtn {
    background-color: red;
}

li.dropdown {
    display: inline-block;
}

.dropdown-content {
    display: none;
    position: absolute;
    background-color: #f9f9f9;
    min-width: 160px;
    box-shadow: 0px 8px 16px 0px rgba(0,0,0,0.2);
}

.dropdown-content a {
    color: black;
    padding: 12px 16px;
    text-decoration: none;
    display: block;
    text-align: left;
}

.dropdown-content a:hover {background-color: #f1f1f1}

.show {display:block;}
</style>
</head>
<body>


<h1 align="center" style="color:red">  University Departmental Portal </h1>
<ul>
  <li class="dropdown">
  	<a href="javascript:void(0)" class="dropbtn" onclick="myFunction()">Message Resource</a>
  	<div class="dropdown-content" id="myDropdown">
  		<a href="http://localhost:8080/UniversityDeptPortal/AddNewResource.jsp">Add New resource</a>
  		<a href="http://localhost:8080/UniversityDeptPortal/ViewResources">Reserve Resource</a>
  		<a href="http://localhost:8080/UniversityDeptPortal/ReservedResourceByUser">Cancel Resource</a>
  	</div>	
  </li>
   <li class="dropdown">
  	<a href="javascript:void(0)" class="dropbtn" onclick="myFunction1()">Courses</a>
  	<div class="dropdown-content" id="myDropdown1">
  		<a href="http://localhost:8080/UniversityDeptPortal/CreateCourse.jsp"> Create A Course</a>
  		<a href="http://localhost:8080/UniversityDeptPortal/ViewCourses"> View All the Courses</a>
  		<a href="http://localhost:8080/UniversityDeptPortal/CourseOfferedByLoggedInFaculty">Post Course Details</a>
  		<a href="http://localhost:8080/UniversityDeptPortal/ViewCourseDetails">View Course Details</a>
  		
  	</div>	
  </li> 
  
  <li class="dropdown">
    <a href="javascript:void(0)" class="dropbtn" onclick="myFunction2()">Student Status</a>
    <div class="dropdown-content" id="myDropdown2">
         <a href="http://localhost:8080/UniversityDeptPortal/SubmitPhDStudentDetails.jsp">Submit Student Details</a>
       <a href="http://localhost:8080/UniversityDeptPortal/ViewProfessorOfficeHr">View Pofessor's Office Hour</a>
       <a href="http://localhost:8080/UniversityDeptPortal/ViewEmailIdOfProfessor">Send Email to Professor</a>
      <a href="http://localhost:8080/UniversityDeptPortal/ViewPhDStudents">View PhD Student Details</a>
      
    </div>
  </li>
  
   <li class="dropdown">
    <a href="javascript:void(0)" class="dropbtn" onclick="myFunction3()">Discussion Forum</a>
    <div class="dropdown-content" id="myDropdown3">
      <a href="http://localhost:8080/UniversityDeptPortal/CreateDiscussionTopic.jsp">Create Discussion Topic</a>
      <a href="http://localhost:8080/UniversityDeptPortal/SelectDiscussionTopics">Participate in Discussion</a>
      
    </div>
  </li>
  
   <li class="dropdown">
    <a href="javascript:void(0)" class="dropbtn" onclick="myFunction4()">Announcements</a>
    <div class="dropdown-content" id="myDropdown4">
      <a href="http://localhost:8080/UniversityDeptPortal/Announcement.jsp">Post Announcements</a>
      <a href="http://localhost:8080/UniversityDeptPortal/ViewAnnouncements">View Announcements</a>
      <a href="http://localhost:8080/UniversityDeptPortal/JobDetail.jsp">Jobs</a>
      <a href="http://localhost:8080/UniversityDeptPortal/ViewAppliedJob">View Applied Job by Student</a>
      
    </div>
  </li> 
  
  <li class="dropdown">
    <a href="javascript:void(0)" class="dropbtn" onclick="myFunction5()">Exams and Results</a>
    <div class="dropdown-content" id="myDropdown5">
      <a href="http://localhost:8080/UniversityDeptPortal/CreateExam.jsp">Create Exam</a>
      <a href="http://localhost:8080/UniversityDeptPortal/ViewExamDetails">Student Register Exam Here</a>
      <a href="http://localhost:8080/UniversityDeptPortal/StudentExamResult">Post Results</a>
      <a href="http://localhost:8080/UniversityDeptPortal/ViewResultOfStudent">View Results</a>
      <!-- <a href="http://localhost:8080/UniversityDeptPortal/StudentRegisterExam">Register for Exam</a> -->
      
    </div>
  </li> 
  
  <li class="dropdown">
    <a href="javascript:void(0)" class="dropbtn" onclick="myFunction6()">Alumni Info</a>
    <div class="dropdown-content" id="myDropdown6">
      <a href="http://localhost:8080/UniversityDeptPortal/PostAlmniInfo.jsp">Post Alumni Info</a>
      <a href="http://localhost:8080/UniversityDeptPortal/ViewAlumniDetails">View Alumni Details</a>
      
    </div>
  </li> 
  	
 <li>
 	<div><a href="http://localhost:8080/UniversityDeptPortal/LogOutUser">Log Out</a></div>
 </li> 
</ul>


<script>
/* When the user clicks on the button, 
toggle between hiding and showing the dropdown content */
	function myFunction() {
    document.getElementById("myDropdown").classList.toggle("show");
	}
	function myFunction1() {
    document.getElementById("myDropdown1").classList.toggle("show");
	}
	function myFunction2() {
    document.getElementById("myDropdown2").classList.toggle("show");
	}
	function myFunction3() {
    document.getElementById("myDropdown3").classList.toggle("show");
	}
	function myFunction4() {
    document.getElementById("myDropdown4").classList.toggle("show");
	}
	function myFunction5() {
	    document.getElementById("myDropdown5").classList.toggle("show");
	}
	function myFunction6() {
	    document.getElementById("myDropdown6").classList.toggle("show");
	}


// Close the dropdown if the user clicks outside of it
window.onclick = function(e) {
  if (!e.target.matches('.dropbtn')) {

    var dropdowns = document.getElementsByClassName("dropdown-content");
    for (var d = 0; d < dropdowns.length; d++) {
      var openDropdown = dropdowns[d];
      if (openDropdown.classList.contains('show')) {
        openDropdown.classList.remove('show');
      }
    }
  }
} 
</script>

</body>
