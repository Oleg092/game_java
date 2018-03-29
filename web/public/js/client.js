function inputText(id){
	var text = id;
	var size;
	size = document.getElementById('num').value;
	if (size.length < 4) {
		document.getElementById('num').value+=text;
	}
	
	
}
function clean(){
	document.getElementById('num').value="";
}