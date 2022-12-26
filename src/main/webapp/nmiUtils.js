/**
 * 
 */

function getTable(data) {
	var tbl = "<table name='listTable'>",
		cols = [], siz = 0;
	if (Array.isArray(data)) {
		let r = data[0];
		tbl += "<thead><tr>";
		for (let col in r) {
			tbl += "<td>" + col + "</td>";
			cols.push(col);
			siz++;
		}
		tbl += "</tr></thead><tbody>";
		data.forEach(itm => {
			tbl += "<tr>";
			for (let i = 0; i < siz; i++) {
				tbl += "<td>" + itm[cols[i]] + "</td>";
			}
			tbl += "</tr>";
		});
	}
	tbl += "</tbody></table>";
	return tbl;
}

function getRecord(data) {
	var frm = "<form>";
	if (Array.isArray(data)) {
		let r = data[0];
		for (let col in r) {
			frm += "<label for='" + col + "'>" + col + "</label><input name='" + col + "''/><br/>";
		}
	}
	frm += "</form>";
	return frm;
}

function loadRow(a, b, c){
    debugger;
    console.log(a + " "  + b);    
}

