<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
  <title>Shipment Tracking</title>
  <style>
     body {
       font-family: Arial, sans-serif;
     }

    h1 {
      text-align: center;
    }

    form {
      margin: 0 auto;
      width: 300px;
      padding: 20px;
      border: 1px solid #ccc;
      border-radius: 5px;
    }
    button{
      width: 100%;
      padding: 10px;
      background-color: #4CAF50;
      color: white;
      border: none;
      border-radius: 4px;
      cursor: pointer;
    }
    label {
      display: block;
      margin-bottom: 10px;
    }

    input[type="text"] {
      width: 100%;
      padding: 10px;
      margin-bottom: 10px;
      border: 1px solid #ccc;
      border-radius: 4px;
      box-sizing: border-box;
    }

     .shipment-details{
       margin: 0 auto;
       width: 300px;
       padding: 20px;
       border: 1px solid #ccc;
       border-radius: 5px;
    }

    .error-message {
      color: red;
    }
    h2{
      text-align: center;
    }


  </style>
</head>
<body>
<div class="container">
<h1>Shipment Tracking</h1>
<form  id="myForm" action="../../shipping/track" method="POST">
  <label for="item">Item ID:</label>
  <input type="text" id="item" name="item" >
  <button type="submit" onclick="submitForm()" >Track</button>
</form>
  <script>
    data:{
    }
    function submitForm() {
      var form = document.getElementById("myForm");
      // 获取当前URL
      var currentUrl = form.action;
      // 构建新的URL路径
      var newUrl = currentUrl.replace("/shipping/track", "/app/shipping/track");
      // 获取表单元素
      var form = document.getElementById("myForm");
      // 设置表单的action属性为新的URL路径
      form.action = newUrl;
      // 提交表单
      form.submit();
      // 获取表单元素
      var form = document.getElementById("myForm");
      // 提交表单
      form.submit();
    }
  </script>
  <%--@elvariable id="shipment" type="com.entity.Shipment" --%>
<c:if test="${not empty shipment}">
  <div class="shipment-details">
    <h2>Shipment Details</h2>
    <p>Address: <c:out value="${shipment.returnto}"/></p>
    <p>UpdateAt: <c:out value="${shipment.updateat}"/></p>
  </div>
</c:if>
  <a href="main">Back to Main Menu</a>
</div>
</body>
</html>