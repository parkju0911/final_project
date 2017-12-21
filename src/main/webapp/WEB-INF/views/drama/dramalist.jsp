<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="../css/review/review.css" rel="stylesheet">
<title>Insert title here</title>
</head>
<body>
	<!-- Header 시작 -->
	<%-- <c:import url="../temp/header.jsp"></c:import> --%>
	<!-- Header 끝 -->


	<div
		class="xans-element- xans-board xans-board-title-1002 xans-board-title xans-board-1002 location-board ">
	
		<div class="tit-board">
			<p class="img"></p>
			<h2>
				<font color="#555555">${fn:toUpperCase(requestScope.board)}</font>
			</h2>
			
		</div>
	</div>

	<div class="container review">
		<div id="review-feed-list-wrap">
			<div class="row unpa-card-row row-flex-height-md">
				<c:forEach items="${requestScope.list}" var="dto">
					<div class="col-md-4 unpa-ad-responsive-parent">

						<div class="unpa-card unpa-card-box-shadow unpa-review">

							<div class="main-section"
								style="border-left: 1px solid #f2f2f2; border-top: 1px solid #f2f2f2; border-right: 1px solid #f2f2f2;">
								<a class="user-info-link" href="">
									<div class="user-info" style="display: inline-block">
										<div class="unpa-feed-user-info-box">
											<div class="unpa-user-block">
												<div class="user-name unpa-tooltip" data-html="true"
													data-toggle="tooltip" data-placement="bottom"
													title="<i class='ion-person'></i> 267 <i class='ion-edit'></i> 40">
													${dto.writer}</div>
												<div class="user-labels" style="">
													<span class="skin-type false ">${dto.tone}</span>
												</div>
											</div>
										</div>
									</div>
									<div class="time">${dto.reg_date}</div>
								</a>
								<div class="unpa-feed-card-hover-actions">
									<span class="unpa-share-this-button"><i
										class="unpacon-share"></i></span>

									<div class="number-of-images">
										<i class="glyphicon glyphicon-picture"></i> 6
									</div>

								</div>

								<div class="main-image"
									style="background-image:  url('../upload/${dto.fname}')">
									<div class="content">
										<a>${dto.contents}</a>
									</div>
								</div>
								<div class="review-contents">
									<div class="product-info">
										<div class="left">
											<div class="product-image"
												style="background-image: url('${pageContext.request.contextPath}/image/review/unpa-product-default.png')"></div>
										</div>


										<div class="right">
											<div class="brand-name-and-rating">
												<div class="brand-name">
													<a
														href="./${requestScope.board}View.${requestScope.board}?num=${dto.num}">${dto.title}</a>
												</div>
											</div>
											<div class="product-name">
												<a
													href="./${requestScope.board}View.${requestScope.board}?num=${dto.num}">${dto.pname}</a>
											</div>
										</div>
									</div>
								</div>
							</div>
							<div class="sub-section"
								style="border-left: 1px solid #f2f2f2; border-bottom: 1px solid #f2f2f2; border-right: 1px solid #f2f2f2;">
								<div class="count-info">
									<%-- <div class="like">
										<a class="like-button " style="color: #b4b4b4;">
											<div class="icon">
											<img
											src="${pageContext.request.contextPath}/image/review/ic_heart_xs_normal.png"></div>
											<div class="count">${dto.heart}</div>
										</a>
									</div>
									<div class="comments">
										<img
											src="${pageContext.request.contextPath}/image/review/ic_reply_s.png">
										<div style="display: inline; position: relative; top: 1px;">${dto.ref}</div>
									</div> --%>

									<div class="views">
										<div style="display: inline; position: relative; top: 1px;">${dto.hit}
											view</div>

									</div>
								</div>
							</div>
						</div>
					</div>
				</c:forEach>
			</div>
		</div>
	

	<div class="text-center">
      <ul class="pagination">
         <c:if test="${page.curBlock>1}">
            <li><button class="go" id="${page.startNum-1}">[이전]</button></li>
         </c:if>

         <c:forEach begin="${page.startNum}" end="${page.lastNum}" var="i">
            <li><a
               href="./${requestScope.board}List.${requestScope.board}?curPage=${i}">${i}</a></li>
         </c:forEach>

         <c:if test="${page.curBlock < page.totalBlock}">
            <li><a
               href="./${requestScope.board}List.${requestScope.board}?curPage=${requestScope.page.lastNum+1}">[다음]</a></li>
         </c:if>
      </ul>
   </div>
         <c:if test="${not empty member}">
      <div class="write-btn"
         style="float: right; width: 84px; height: 23px;     margin-top: 60px; border-radius: 123px; background-color: #a09d9dcc;">
            <a href="./reviewWrite.review"
               style="color: white; margin: auto; padding: 20px; font-weight: 600;">WRITE</a>
      </div>
         </c:if>
         </div>

	<!-- footer 시작 -->
	<%-- <c:import url="../temp/footer.jsp"></c:import> --%>
	<!-- footer 끝 -->
</body>
</html>