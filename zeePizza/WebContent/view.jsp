<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="sql"
uri="http://java.sun.com/jsp/jstl/sql"
 %>
<%@ taglib prefix ="c"
uri = "http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<style type = "text/css">
	
</style>

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>View</title>

    <!-- Bootstrap Core CSS -->
    <link href="bootstrap/css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom CSS -->
    <link href="bootstrap/css/business-casual.css" rel="stylesheet">

    <!-- Fonts -->
    <link href="https://fonts.googleapis.com/css?family=Open+Sans:300italic,400italic,600italic,700italic,800italic,400,300,600,700,800" rel="stylesheet" type="text/css">
    <link href="https://fonts.googleapis.com/css?family=Josefin+Slab:100,300,400,600,700,100italic,300italic,400italic,600italic,700italic" rel="stylesheet" type="text/css">

    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
        <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->

</head>

<body>
<sql:setDataSource var="ds"
	driver = "oracle.jdbc.OracleDriver"
	url="jdbc:oracle:thin:@localhost:1521:xe"
	user="ZeePizza"
	password="admin"
	/>

    <div class="brand">Zee Pizza</div>
    <div class="address-bar">2154 Great Job | San Francisco, CA 94101 | 443.684.9341</div></br>
    
     <span class = "welcome" >Welcome <%=session.getAttribute("empFirstName")%>!</span>
     <form method = "post" action = "empLogout">
     <input type = "submit" value = "logout"/>
     </form>  

    
    
    <!-- Navigation -->
    <nav class="navbar navbar-default" role="navigation">
        <div class="container">
            <!-- Brand and toggle get grouped for better mobile display -->
            <div class="navbar-header">
                <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <!-- navbar-brand is hidden on larger screens, but visible when the menu is collapsed -->
                <a class="navbar-brand" href="pizzaHome.jsp">Zee Pizza</a>
            </div>
            <!-- Collect the nav links, forms, and other content for toggling -->
            <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                <ul class="nav navbar-nav">
                    <li>
                        <a href="pizzaEmpPortal.jsp">Employee Home</a>
                    </li>
                    <li>
                        <a href="view.jsp">View Employees</a>
                    </li>
                    <li>
                        <a href="vehicle.jsp">Vehicles</a>
                    </li>
                    <li>
                        <a href="pizzaAnalysis.jsp">Analytics</a>
                    </li>

                </ul>
            </div>
            <!-- /.navbar-collapse -->
        </div>
        <!-- /.container -->
    </nav>

    <div class="container">

        <div class="row">
            <div class="box">
                <div class="col-lg-12 text-center">
                <sql:query dataSource="${ds}" var="rs">
               select e.employeeID, e.firstName, e.lastName, e.phoneNumber, t.typetitle, e.vinnumber, email from employee e left join type t on e.typeID = t.typeID where supervisorID = '<%= session.getAttribute("employeeID") %>'
                </sql:query>
                <!-- general manager view, gets all employees he/she supervisor -->
                <table border = "1px">
				<c:forEach var = "row" items="${rs.rows}">
				<tr><th>EmployeeID<th>First Name</th><th>Last Name</th><th>Phone Number</th><th>Title</th><th>Vin number</th><th>email</th></tr>
				<tr><td>${row.EmployeeID}</td><td>${row.FirstName}</td><td>${row.LastName}</td><td>${row.PhoneNumber}</td><td>${row.typetitle}</td><td>${row.vinnumber}</td><td>${row.email}</td></tr>	
				</c:forEach>
				</table>
                </div>
            </div>
        </div>



    <footer>
        <div class="container">
            <div class="row">
                <div class="col-lg-12 text-center">
                	
					&copy; 2016 Zaren Balisi || Last Modified: <script type="text/javascript"> document.write(document.lastModified);</script>
					
                </div>
            </div>
        </div>
    </footer>

    <!-- jQuery -->
    <script src="js/jquery.js"></script>

    <!-- Bootstrap Core JavaScript -->
    <script src="js/bootstrap.min.js"></script>

    <!-- Script to Activate the Carousel -->
    <script>
    $('.carousel').carousel({
        interval: 5000 //changes the speed
    })
    </script>

</body>
</html>