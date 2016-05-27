<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

	<table>
		<tbody>

			<s:iterator value="nameList">
				<tr>
					<td><s:property value="name" /></td>
					<td><s:property value="comment" /></td>
				</tr>
			</s:iterator>
		</tbody>
	</table>

	<a href="insert.jsp"><button type="button"onclick="location.href('http://localhost:8080/prototype1605/insert.jsp')"
style="background-color:#759632;"
onmouseover="this.style.background='#85f64f'"
onmouseout="this.style.background='#759632'">
TOP( ◔ิω◔ิ) </button></a>
</body>
</html>