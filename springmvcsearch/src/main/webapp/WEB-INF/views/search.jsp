<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page isELIgnored="false" %>
<!doctype html>
<html lang="en">
<head>
<!-- Required meta tags -->
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">

<!-- Bootstrap CSS -->
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous">

<title>Submit Form</title>
</head>
<body>
	<div class="container mt-5" style=" color:red;">

		<h1 class="text-center">Search Engine</h1>
		<h4 class="text-center">${Header }</h4>
		<form action="processform" method="post">
			<div class="form-group text-center">
				<label for="exampleInputSearch">Enter your Search</label> <input type="text"
					class="form-control" id="exampleInputSearch"
					placeholder="Enter search" name="search">
			</div>
			<div class="button text-center">
				<button type="submit" class="btn btn-success">Submit</button>
			</div>
		</form>
	</div>