/**
 * 
 */
 
 function itemlistlist(iteminfo){

	let str = `
	<div class="card " style="width: 18rem;">
 <a href = "/item/read/${iteminfo.iId}">
 <div>
  <img src="/displayfile?filename=${iteminfo.ifilename}"class="card-img-top" alt="..." width="100px" height="200px">
  </div>
  </a>
  <div class="card-body">
    <p class="card-text">상품이름:${iteminfo.iName}</p>
    <p class="card-price">상품가격:${iteminfo.iPrice}</p>
  </div>
</div>
	
	`;
	return str;
}

function gocategoryitem(category,itemlist) {
	tagstr = "";
			$.getJSON("/item/category/"+category+"/all", function(data) {
				for(let i = 0 ; i < data.length;i++){
					let iteminfo = data[i];
					let str = itemlistlist(iteminfo);
					tagstr += str;
				}
				itemlist.html(tagstr);

			})
		}

function changecategory() {
		let category = document.getElementById("category");
		let selectcategory = category.options[category.selectedIndex].value;
		$("#input").val(selectcategory);
	}



function insertitemimgfile(result, itemimgfilename,itemimgfilekey){
   let str = `
<div class="col mb-4">
   <div class="card itemimgfilename border-primary text-center">
		<div>
      <img src="${result}" alt="" width="100px" height="100px">
		</div>
      <div class="card-body">
          <p class="card-text">${itemimgfilename}</p>
          <a href="#" data-itemimgfilekey = "${itemimgfilekey}" data-itemimgfilename = "new" class="btn btn-danger btn_del_item" >삭제</a>
      </div>
   </div>
</div>
   `;
   
   return str;
} 