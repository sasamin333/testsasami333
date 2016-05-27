<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>The practice of D3.js</title>
</head>
<body>

	<form>
	<select onChange="top.location.href=value">
		<option value="#">MENU</option>
		<option value="user.jsp">ユーザー情報</option>
		<option value="login.jsp">登録情報</option>
	</select>
	</form>

	<h1>グラフやん</h1>
    <script src="http://d3js.org/d3.v3.min.js" charset="utf-8"></script>

    <script>
        var dataset = [13, 25, 63, 30, 59, 22];

        var w = 500;
        var h = 240;
        var padding = 20;

        var xScale = d3.scale.linear()
                        .domain([0, d3.max(dataset)])
                        .range([padding, w - padding])
                        .nice();

        var svg = d3.select("body").append("svg").attr({width:w, height:h});
        var xAxis = d3.svg.axis()
                       .scale(xScale)
                       .orient("bottom")
         svg.append("g")
             .attr({
                class: "axis",
                transform: "translate(0, 220)"
                })
             .call(xAxis);

         svg.selectAll("rect")
            .data(dataset)
            .enter()
            .append("rect")
            .on("mouseover", function(d) {
                d3.select(this).attr("fill", "orange");
            })
            .on("mouseout", function(d) {
                d3.select(this).attr("fill", "blue");
            })
            .on("click", function(d) {
                var rs = d3.select(this).attr("r");
                alert(rs);
            })
            .attr({
                x: padding,
                y: function(d, i) { return 50 + (i * 25); },
                r : function(d) { return d; },
                width : function(d) { return xScale(d) - padding; },
                height: 20,
                fill: "blue"
            });
    </script>

	<svg id="myGraph"></svg>
	<script src="js/d3.js"></script>

	<div class="form" align="right"></div>

<s:form action="GoD3">
 <form action="GoD3"><input type="text" /></form>
	<form action="GoD3"><input class="btn" type="submit" value="戻る"/></form>
</s:form>

</body>
</html>