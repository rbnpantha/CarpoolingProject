var a;
$(function(){
	$.post("DeletePost").done(function(exp){
			x=exp;
			$.each(exp.Message,function(i,data){
			
				var msg_data="";
				msg_data+="<form action='DeletePostUser' method='post'>"+data.post+"<br><button class='like' data-postid=\""+data.postid+"\">Delete</button><input type='hidden' value='"+data.postid+"' name='txthidden'></form><br>";
				$("#dicdelete").append(msg_data);
			})	
	
	}).fail(function(xhr,status,exception){
		console.log(1);
	})
	
})