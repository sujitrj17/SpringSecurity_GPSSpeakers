$(document).ready( function () {
	 var table = $('#speakerTable').DataTable({
			"sAjaxSource": "/getReport",
			"sAjaxDataProp": "",
			"order": [[ 0, "asc" ]],
			"aaData": data,
			"aoColumns": [
			    { "mData": "id"},
		      { "mData": "website" },
				  { "mData": "name" },
				  { "mData": "position" },
				  { "mData": "email" },
				  { "mData": "contactno" },
				   { "mData": "address" }
			],
			"paging":true
	 })
});