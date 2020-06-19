function itemDelete(itemId){
	
		console.log(itemId);
		$.ajax({
			type: "post",
			url: "/fruit/product?cmd=deleteProc",
			data: "itemId="+itemId, //request.getparameter 로 받을수있음
			contentType: "application/x-www-form-urlencoded; charset=utf-8",
			dataType: "text"
		}).done(function(result){
			if(result == "1"){
			alert("삭제 성공");
			var Item = $(".productitem__"+itemId);
			console.log(Item);
			Item.remove();
			}
		}).fail(function(error){
			alert("삭제 실패");
		});
}

function priceSort(){
			$.ajax({
				type: 'get',
				url: '/fruit/product?cmd=priceSort'
			}).done(function(result){
				$("#table").empty();
				console.log(result);
				renderTableList(result);
			}).fail(function(error){
				alert(error);
				console.log(error);
			});
}

function first(){
	$.ajax({
		type: 'get',
		url: '/fruit/product?cmd=first'
	}).done(function(result){
		$("#table").empty();
		console.log(result);
		renderTableList(result);
	}).fail(function(error){
		alert(error);
		console.log(error);
	});
}

function countSort(){
	$.ajax({
		type: 'get',
		url: '/fruit/product?cmd=countSort'
	}).done(function(result){
		$("#table").empty();
		console.log(result);
		renderTableList(result);
	}).fail(function(error){
		alert(error);
		console.log(error);
	});
}


function renderTableList(products){
		for(var product of products){
			$("#table").append(makeItem(product));
		}
}


function makeItem(product){
	var replyItem = `<tr class="productitem__${product.id}">`
	replyItem += `<td>${product.id}</td>`
	replyItem += `<td>${product.name}</td>`
	replyItem += `<td>${product.type}</td>`
	replyItem += `<td>${product.price}</td>`
	replyItem += `<td>${product.count}</td>`
	replyItem +=`<td><button onclick="itemDelete(${product.id})">삭제</button></td>`
	replyItem +=`</tr>`
	
	return replyItem;
} 


