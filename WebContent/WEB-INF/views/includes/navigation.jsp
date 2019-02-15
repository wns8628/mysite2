<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>  
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<ul>
	<c:choose>
		<c:when test="${param.menu == 'main' }">
			<li class="selected"><a href="${pageContext.servletContext.contextPath }">김세준</a></li>
			<li><a href="${pageContext.servletContext.contextPath }/guestbook?a=list">방명록</a></li>
			<li><a href="${pageContext.servletContext.contextPath }/guestbook?a=ajax">방명록(Ajax)</a></li>			
			<li><a href="${pageContext.servletContext.contextPath }/board?a=list">게시판</a></li>
		</c:when>

		<c:when test="${param.menu == 'guestbook' }">		
			<li><a href="${pageContext.servletContext.contextPath }">김세준</a></li>
			<li class="selected"><a href="${pageContext.servletContext.contextPath }/guestbook?a=list">방명록</a></li>
			<li><a href="${pageContext.servletContext.contextPath }/guestbook?a=ajax">방명록(Ajax)</a></li>
			<li><a href="${pageContext.servletContext.contextPath }/board?a=list">게시판</a></li>
		</c:when>

		<c:when test="${param.menu == 'guestbook-ajax' }">		
			<li><a href="${pageContext.servletContext.contextPath }">김세준</a></li>
			<li><a href="${pageContext.servletContext.contextPath }/guestbook?a=list">방명록</a></li>
			<li class="selected"><a href="${pageContext.servletContext.contextPath }/guestbook?a=ajax">방명록(Ajax)</a></li>
			<li><a href="${pageContext.servletContext.contextPath }/board?a=list">게시판</a></li>
		</c:when>
		
		<c:when test="${param.menu == 'board' }">		
			<li><a href="${pageContext.servletContext.contextPath }">김세준</a></li>
			<li><a href="${pageContext.servletContext.contextPath }/guestbook?a=list">방명록</a></li>
			<li><a href="${pageContext.servletContext.contextPath }/guestbook?a=ajax">방명록(Ajax)</a></li>
			<li class="selected"><a href="${pageContext.servletContext.contextPath}/board?a=list">게시판</a></li>
		</c:when>		
		
		<c:otherwise>
			<li><a href="${pageContext.servletContext.contextPath }">김세준</a></li>
			<li><a href="${pageContext.servletContext.contextPath }/guestbook?a=list">방명록</a></li>
			<li><a href="${pageContext.servletContext.contextPath }/guestbook?a=list?a=ajax">방명록(Ajax)</a></li>
			<li><a href="${pageContext.servletContext.contextPath }/board?a=list">게시판</a></li>
		
		</c:otherwise>
	</c:choose>
</ul>