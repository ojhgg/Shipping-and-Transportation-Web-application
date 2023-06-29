<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html xmlns:th="http://www.thymeleaf.org">
<head>
  <style>body {
    font-family: Arial, sans-serif;
    margin: 20px;
  }

  h1 {
    color: #333;
  }

  form {
    margin-bottom: 20px;
  }

  label {
    display: block;
    margin-bottom: 10px;
  }

  input[type="text"] {
    width: 300px;
    padding: 5px;
    font-size: 14px;
  }

  input[type="submit"] {
    padding: 10px 20px;
    font-size: 16px;
    background-color: #333;
    color: #fff;
    border: none;
    cursor: pointer;
  }

  .success-message {
    color: green;
    font-weight: bold;
  }

  .error-message {
    color: red;
    font-weight: bold;
  }
  </style>
  <meta charset="UTF-8">
  <title>Create Shipment</title>
  <link rel="stylesheet" type="text/css" href="styles.css">
</head>
<body>
<h1>Create Shipment</h1>
<form action="../shipping/create" method="post" th:object="${shipment}">
  <label for="id">UserId:</label>
  <input type="text" id="id" name="id" th:field="*{id}"><br><br>
  <label for="paidby">paid-by:</label>
  <input type="text" id="paidby" name="paidby" th:field="*{paidby}"><br><br>

  <label for="accountnumber">AccountNumber:</label>
  <input type="text" id="accountnumber" name="accountnumber" th:field="*{accountnumber}"><br><br>

  <label for="returnto">Return To:</label>
  <input type="text" id="returnto" name="returnto" th:field="*{returnto}"><br><br>

  <label for="shipfrom">Ship From:</label>
  <input type="text" id="shipfrom" name="shipfrom" th:field="*{shipfrom}"><br><br>

  <label for="shipto">Ship To:</label>
  <input type="text" id="shipto" name="shipto" th:field="*{shipto}"><br><br>

  <label for="servicetype">Service Type:</label>
  <select id="servicetype" name="servicetype" th:field="*{servicetype}">
    <option value="Standard">Standard</option>
    <option value="Express">Express</option>
    <option value="Priority">Priority</option>
  </select><br><br>

  <label for="parcels">Parcels:</label>
  <input type="text" id="parcels" name="parcels" th:field="*{parcels}"><br><br>

  <input type="submit" value="Submit">
</form>

<!-- 根据消息类型显示成功或失败的消息 -->
<c:if test="${createMessage}" > <div>Shipment created successfully!</div> </c:if>
<c:if test="${errorMessage}"><div> Failed to create shipment. Please try again.</div> </c:if>

<!-- 返回到主菜单界面的链接 -->
<a href="main">Back to Main Menu</a>
</body>
</html>