<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
            <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    
<div class="sidebar">
<div class="recent">
<h4 class="title">Recently Viewed items</h4>

<div class="recentitems">
<ul>

 <c:if test="${cookie.artist1 != null}">
<a href="singlelisting?id=${cookie.control_id1.value}&artist=${cookie.control_art1.value}&title=${cookie.title1.value}"><li>${cookie.artist1.value}</li></a>
</c:if>
<c:if test="${cookie.artist2 != null}">
<a href="singlelisting?id=${cookie.control_id2.value}&artist=${cookie.control_art2.value}&title=${cookie.title2.value}"><li>${cookie.artist2.value}</li></a>
</c:if>
<c:if test="${cookie.artist3 != null}">
<a href="singlelisting?id=${cookie.control_id3.value}&artist=${cookie.control_art3.value}&title=${cookie.title3.value}"><li>${cookie.artist3.value}</li></a>
</c:if>
<c:if test="${cookie.artist4 != null}">
<a href="singlelisting?id=${cookie.control_id4.value}&artist=${cookie.control_art4.value}&title=${cookie.title4.value}"><li>${cookie.artist4.value}</li></a>
</c:if>
<c:if test="${cookie.artist5 != null}">
<a href="singlelisting?id=${cookie.control_id5.value}&artist=${cookie.control_art5.value}&title=${cookie.title5.value}"><li>${cookie.artist5.value}</li></a>
</c:if>
</ul>
<c:if test="${cookie.artist1 == null && cookie.artist2 == null && cookie.artist3 ==null && cookie.artist4 == null && cookie.artist5==null}">
<p>Start Shopping now!</p>
</c:if>

</div>
</div>

</div>