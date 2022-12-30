/** Naeem Iqbal Utilities
 * 
 */
var store = [];

function loader() {
	var req = new XMLHttpRequest();
	req.open("GET", RESTURL);
	req.onreadystatechange = respGet;
	req.send();
	addEvents();
	document.addEventListener('change', (event) => {
		if (event.target.name === 'list') {
			addEvents();
		}
	});
	document.getElementsByName("save")[0].addEventListener('click', save);
	document.getElementsByName("delete")[0].addEventListener('click', deleteRec);
}

function respGet(r) {
	var t, s;
	if (r) {
		t = r.target;
		if (t.readyState === 3) {
			s = JSON.parse(t.responseText);
			document.getElementsByName("list")[0].innerHTML = getTable(s);
			document.getElementsByName("record")[0].innerHTML = getRecord(s);
		}
		setTimeout(addEvents, 1000);
	}
}

function getTable(data) {
	var tbl = "<table name='listTable'>",
		cols = [], siz = 0, c = 0;
	if (Array.isArray(data)) {
		store = data;
		let r = data[0];
		tbl += "<thead><tr>";
		for (let col in r) {
			tbl += "<td>" + col + "</td>";
			cols.push(col);
			siz++;
		}
		tbl += "</tr></thead><tbody>";
		data.forEach(itm => {
			tbl += "<tr rowNMIID='" + c++ + "'>";
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
			frm += "<label for='" + col + "'>" + col + "</label><input name='" + col + "''/>";
		}
	}
	frm += "</form>";
	return frm;
}

function addEvents() {
	let tbl = document.querySelector("[name=listTable]");
	if (tbl) {
		for (const currentRow of tbl.rows) {
			currentRow.onclick = loadRow;
		}
	}
}

function loadRow(ele) {
	var id = ele.currentTarget.getAttribute("rownmiid"),
		rec = document.getElementsByName("record"),
		flds = Array.from(rec[0].getElementsByTagName("input"));
	let r = store[id];
	flds.forEach(inp => {
		inp.value = r[inp.name];
	});
	console.log(id);
}

function save() {
	var frm = document.forms[0],
		flds = Array.from(frm.elements),
		data = {},
		id;
	flds.forEach(itm => {
		data[itm.name] = itm.value;
	});
	id = data.storeID;
	if (id)
		ajax("PUT", id, data);
	else
		ajax("POST", null, data);
}

function ajax(method, id, data) {
	var req = new XMLHttpRequest();
	req.open(method, RESTURL + (id === null ? "" : id), data);
	req.setRequestHeader('Content-Type', 'application/json');
	req.onreadystatechange = respSave;
	try {
		req.send(JSON.stringify(data));
	}
	catch (err) {
		console.log(err);
		alert(err);
	}
	console.log(method + "\t" + JSON.stringify(data));
}

function respSave(r) {
	var t, s;
	if (r) {
		t = r.target;
		if (t.readyState === 4) {
			/* Ready state 2 loading, 3 interactive, 4 complete */
			if (s) {
				s = JSON.parse(t.responseText);
				console.log(s);
			}
			document.forms[0].submit();
		}
		console.log(t);
	}
}

function deleteRec() {
	var frm = document.forms[0],
		flds = Array.from(frm.elements),
		id
		//id = frm.down("name="+ID)
		;
	flds.forEach(itm => {
		if (itm.name === ID)
			id = itm.value;
	});
	if (id)
		ajax("DELETE", id, {});
	else
		alert("No ID for delete ");
}