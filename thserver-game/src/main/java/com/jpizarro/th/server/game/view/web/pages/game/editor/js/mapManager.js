var map;
var markers;

var game;

var selectedItem;
var infowindow;
var geocoder;

var selectedCity;
var selectedLatitude;
var selectedLongitude;
var selectedOnClickAction;

/**
 * Paths to item images
 */

var hintImage = '${COIN_IMG}';

var createURL = '${CREATE_URL}';

var viewURL = '${VIEW_URL}';

var hintIcon;

var goalIcon;


$(document).ready(function() {
	game = new Game();
	$('#addHintButton').removeAttr('disabled');
	$('#addGoalButton').removeAttr('disabled');
	
	geocoder = new google.maps.Geocoder();
//	var latlng = new google.maps.LatLng(-35.422753, -71.657266);
//	
//	var myOptions = {
//			zoom: 12,
//			center: latlng,
//			mapTypeId: google.maps.MapTypeId.ROADMAP,
//			mapTypeControl: true,
//			navigationControl: true,
//			navigationControlOptions: {
//				style: google.maps.NavigationControlStyle.ZOOM_PAN,
//				position: google.maps.ControlPosition.LEFT
//			}
//		};
//	map = new google.maps.Map(document.getElementById('mapCanvas'), myOptions);

//	function OSMMapType() {}
//	OSMMapType.prototype = {
//		tileSize: new google.maps.Size(256,256),
//		maxZoom: 18,
//		getTile: function(coord, zoom, ownerDocument) {
//			var tileUrl = 'http://tile.openstreetmap.org/' + zoom + '/' + coord.x + '/' + coord.y + '.png';
//
//			var tile = ownerDocument.createElement('img');
//			tile.width = this.tileSize.width;
//			tile.height = this.tileSize.height;
//			tile.src = tileUrl;
//
//			return tile;
//		}
//	};
//	map.mapTypes.set('osm', new OSMMapType());
//	map.setMapTypeId('osm');
	
//	google.maps.event.addListener(map, 'click', function(event) {
//   		doOnClick(event);
//	});

	OpenLayers.Control.Click = OpenLayers.Class(OpenLayers.Control, {                
        defaultHandlerOptions: {
            'single': true,
            'double': false,
            'pixelTolerance': 0,
            'stopSingle': false,
            'stopDouble': false
        },

        initialize: function(options) {
            this.handlerOptions = OpenLayers.Util.extend(
                {}, this.defaultHandlerOptions
            );
            OpenLayers.Control.prototype.initialize.apply(
                this, arguments
            ); 
            this.handler = new OpenLayers.Handler.Click(
                this, {
                    'click': this.trigger
                }, this.handlerOptions
            );
        }, 

        trigger: function(e) {
//            var lonlat = map.getLonLatFromViewPortPx(e.xy);
            var lonlat = map.getLonLatFromViewPortPx(e.xy).transform(
            		new OpenLayers.Projection("EPSG:900913"), // to Spherical Mercator Projection
            		new OpenLayers.Projection("EPSG:4326") // transform from WGS 1984
        	    );
//            alert("You clicked near " + lonlat.lat + " N, " +
//                                      + lonlat.lon + " E");
            doOnClick(e);
        }

    });

	map = new OpenLayers.Map("mapCanvas");

    var mapnik = new OpenLayers.Layer.OSM();
    map.addLayer(mapnik);
    
    markers = new OpenLayers.Layer.Markers( "Markers" );
    map.addLayer(markers);
    
    var size = new OpenLayers.Size(21,25);
    var offset = new OpenLayers.Pixel(-(size.w/2), -size.h);
    var icon = new OpenLayers.Icon('http://www.openlayers.org/dev/img/marker.png',size,offset);
    markers.addMarker(new OpenLayers.Marker(new OpenLayers.LonLat(0,0),icon));

    map.setCenter(new OpenLayers.LonLat(-71.657266, -35.422753) // Center of the map
    	.transform(
    		new OpenLayers.Projection("EPSG:4326"), // transform from WGS 1984
    		new OpenLayers.Projection("EPSG:900913") // to Spherical Mercator Projection
	    ), 13 // Zoom level
    );
    
	var click = new OpenLayers.Control.Click();
	map.addControl(click);
	click.activate();
	
	var size = new OpenLayers.Size(21,25);
	var offset = new OpenLayers.Pixel(-(size.w/2), -size.h);
	hintIcon = new OpenLayers.Icon(hintImage, size, offset);
	
});
function doOnClick(event) {
//	alert("doOnClick");
	if (selectedOnClickAction != null) {
//		alert("selectedOnClickAction != null");
		selectedOnClickAction(event);
	}
}
function selectOnClickAction(action) {
//	alert("selectOnClickAction");
	selectedOnClickAction = action;
}
function changeCityClicked() {
//	alert("changeCityClicked");
	$('#citySpan').html('click anywhere on map');
	$('#latitudeSpan').html('?');
	$('#longitudeSpan').html('?');				
	$('#showCityOptions').hide();
	elements = $('.gameLocationInfoSpan');
	elements.removeClass('gameLocationInfoSpan');
	elements.addClass('gameLocationInfoSpanGrey');
	selectOnClickAction(showCityOptions);
}
function showCityOptions(event) {
//	alert("showCityOptions");
    var lonlat = map.getLonLatFromViewPortPx(event.xy).transform(
    		new OpenLayers.Projection("EPSG:900913"), // to Spherical Mercator Projection
    		new OpenLayers.Projection("EPSG:4326") // transform from WGS 1984
	    );
	if (geocoder) {
		var latLng = new google.maps.LatLng(lonlat.lat, lonlat.lon);
		geocoder.geocode({'latLng': latLng}, function(results, status) {
			if (status == google.maps.GeocoderStatus.OK) {
				if (results[1]) {
					$('#cityOptionsDiv').html('');
					$('#cityOptionsDiv').append('<span id="cityOptionsNote">We found some posible city names. Please select the one you want to be displayed: </span><br/>');
					selectedLatitude = latLng.lat();
					selectedLongitude = latLng.lng();
					for (var i in results[1].address_components) {
						$('#cityOptionsDiv').append('<input id="selectedCityId_' + i + '" type="radio" onclick="selectCity(' + i + ')" value="' + results[1].address_components[i].long_name + '"/><span>' + results[1].address_components[i].long_name + '</span><br/>');
					}
				}
			} else {
				elements = $('.gameLocationInfoSpanGrey');
				elements.removeClass('gameLocationInfoSpanGrey');
				elements.addClass('gameLocationInfoSpan');
				alert('Geocoder failed due to: ' + status);
				$('#cityLabel').html(game.city);
			}
		});
	}
	else {
		elements = $('.gameLocationInfoSpanGrey');
		elements.removeClass('gameLocationInfoSpanGrey');
		elements.addClass('gameLocationInfoSpan');
		$('#cityLabel').html(game.city);
	}
}
function selectCity(index) {
	city = $('#selectedCityId_' + index).val();
	$('#citySpan').html(city);
	$('#latitudeSpan').html(selectedLatitude.toFixed(6));
	$('#longitudeSpan').html(selectedLongitude.toFixed(6));
	game.city = city;
	game.latitude = selectedLatitude;
	game.longitude = selectedLongitude;
	elements = $('.gameLocationInfoSpanGrey');
	elements.removeClass('gameLocationInfoSpanGrey');
	elements.addClass('gameLocationInfoSpan');
	$('#showCityOptions').show();
	$('#cityOptionsDiv').html('');
	selectOnClickAction();
}

function addHint(event) {
	alert('addHint');
	var lonlat = map.getLonLatFromViewPortPx(event.xy);
//	var lonlat = olonlat.transform(
//    		new OpenLayers.Projection("EPSG:900913"), // to Spherical Mercator Projection
//    		new OpenLayers.Projection("EPSG:4326") // transform from WGS 1984
//	    );
//	var latLng = new google.maps.LatLng(lonlat.lat, lonlat.lon);
	id = game.items.length + 1;
	marker = placeMarker(lonlat, id, hintImage);	
	name = '';
	description = '';
	var item = new Hint(id,
			marker,
			name,
			description
			);
	game.items[game.items.length] = item;
	refreshItemsList();
//	selectItem(item);
}
function addGoal(event) {
	alert('addGoal');
	var lonlat = map.getLonLatFromViewPortPx(event.xy);
	id = game.items.length + 1;
	marker = placeMarker(lonlat, id, hintImage);	
	name = '';
	description = '';
	var item = new Goal(id,
			marker,
			name,
			description
			);
	game.items[game.items.length] = item;
	refreshItemsList();
//	selectItem(item);
}
function placeMarker(position, itemId, image) {
	
	var marker = new OpenLayers.Marker(position, hintIcon);
	markers.addMarker(marker);
//	var marker = new google.maps.Marker({
//		position : position, 
//		draggable : true,
//		map : map,
//		clickable : true,
//		icon : image
//	});
//	google.maps.event.addListener(marker, 'click', function() {
//		selectItem(getItem(game.items, itemId));
//	});
//	google.maps.event.addListener(marker, 'dragstart', function() {
//		item = getItem(game.items, itemId);
//		$('#row_' + itemId).html(getUneditableRowContentHtml(item));
//	});
//	google.maps.event.addListener(marker, 'drag', function() {
//		$('#lat_' + itemId).html(marker.position.lat().toFixed(6));
//		$('#lng_' + itemId).html(marker.position.lng().toFixed(6));
//	});
//	google.maps.event.addListener(marker, 'dragend', function() {
//	});
	return marker;
}
function refreshItemsList() {
	$('.itemRow').remove();
	for (var i in game.items) {
		if (game.items[i] != null) {
			addItemToList(game.items[i]);
		}
	}
}
function addItemToList(item) {
	$('#itemsTable').append(
		'<tr class="itemRow unselected" id="row_' + item.id + '">' +
		getUneditableRowContentHtml(item) + '</tr>');
}
function getEditableRowContentHtml(item) {
	return '<td onclick="selectItemById(' + item.id + ')">' + item.id + '</td>' +
		'<td onclick="selectItemById(' + item.id + ')"><div class="itemIcon"><img src="' + item.marker.icon +'"/></div></td>' +
//		'<td onclick="selectItemById(' + item.id + ')"><input id="points_' + item.id + '" type="text" maxlength="6" class="itemInput" value="' + item.points +'"/></td>' +
		'<td onclick="selectItemById(' + item.id + ')"><input id="name_' + item.id + '" type="text" maxlength="6" class="itemInput" value="' + item.name +'"/></td>' +
		'<td onclick="selectItemById(' + item.id + ')"><input id="description_' + item.id + '" type="text" maxlength="6" class="itemInput" value="' + item.description +'"/></td>' +
		'<td onclick="selectItemById(' + item.id + ')"><input id="lat_' + item.id + '" type="text" maxlength="8" class="itemInput" value="' + item.marker.position.lat().toFixed(6) +'"/></td>' +
		'<td onclick="selectItemById(' + item.id + ')"><input id="lng_' + item.id + '" type="text" maxlength="8" class="itemInput" value="' + item.marker.position.lng().toFixed(6) +'"/></td>' +
		'<td><div id="deleteItem_' + item.id + '" class="littleLink"><a href="#" onclick="deleteItem(' + item.id + ')">delete</a></div></td>' + 
		'<td><div id="saveItem_' + item.id + '" class="littleLink"><a href="#" onclick="saveItem(' + item.id + ')">save</a></div></td>';
}
function getUneditableRowContentHtml(item) {
	return '<td onclick="selectItemById(' + item.id + ')">' + item.id + '</td>' +
		'<td onclick="selectItemById(' + item.id + ')"><div class="itemIcon"><img src="' + item.marker.icon.url +'"/></div></td>' +
//		'<td onclick="selectItemById(' + item.id + ')" id="points_' + item.id + '"><span class="itemInfo">' + item.points +'</td>' +
		'<td onclick="selectItemById(' + item.id + ')" id="name_' + item.id + '"><span class="itemInfo">' + item.name +'</td>' +
		'<td onclick="selectItemById(' + item.id + ')" id="description_' + item.id + '"><span class="itemInfo">' + item.description +'</td>' +
		'<td onclick="selectItemById(' + item.id + ')"><span id="lat_' + item.id + '" class="itemInfo">' + item.marker.lonlat.lat +'</td>' +
		'<td onclick="selectItemById(' + item.id + ')"><span id="lng_' + item.id + '" class="itemInfo">' + item.marker.lonlat.lon +'</td>' +
		'<td><div id="deleteItem_' + item.id + '" class="littleLink"><a href="#" onclick="deleteItem(' + item.id + ')">delete</a></div></td>' + 
		'<td><div id="editItem_' + item.id + '" class="littleLink"><a href="#" onclick="editItem(' + item.id + ')">edit</a></div></td>';
}

function doDeleteItem(id) {
	var item = getItem(game.items, id);

	item.marker.setMap(null);
	for (var i in game.items) {
		if (game.items[i] != null && game.items[i].id == item.id) {
				game.items[i] = null;
			}
	}
	item = null;
}
function deleteItem(id) {
	if (confirm('Are you sure?')) {
		doDeleteItem(id);
		refreshItemsList();
	}
}
function editItem(id) {
	item = getItem(game.items, id);
//	$('#points_' + id).val(item.points);
	$('#name_' + id).val(item.name);
	$('#description_' + id).val(item.description);
	$('#row_' + id).html(getEditableRowContentHtml(item));
//	$('#points_' + id).focus();
	for (var i in game.items) {
		if ($('#editItem_' + game.items[i].id) != null) {
			$('#editItem_' + game.items[i].id + ' a').hide();
		}
	}
}
function saveItem(id) {
	item = getItem(game.items, id);
//	item.points = $('#points_' + id).val();
	item.name = $('#name_' + id).val();
	item.description = $('#description_' + id).val();
	$('#row_' + id).html(getUneditableRowContentHtml(item));
	for (var i in game.items) {
		if ($('#editItem_' + game.items[i].id) != null) {
			$('#editItem_' + game.items[i].id + ' a').show();
		}
	}
}
/**
 * Returns the item associated to a marker
 */
function getItem(items, id) {
	return jQuery.grep(items, function(n, i) {
		if (n != null) {
			return n.id == id;
		}
	})[0];
}
function editGameInfo() {
	$('.gameInfoSpan').hide();
	$('#maxTeamsInput').val(game.maxTeams);
	$('#maxUserPerTeamInput').val(game.maxUserPerTeam);
	$('#changeGameInfo').html('');
	$('#changeGameInfo').append('<a href="#changeGameInfo" onclick="saveGameInfo()">save</a>');
	$('.gameInfoInput').show();
}
function saveGameInfo() {
	game.maxTeams = $('#maxTeamsInput').val();
	game.maxUserPerTeam = $('#maxUserPerTeamInput').val();
	$('#maxTeamsSpan').html(game.maxTeams);
	$('#maxUserPerTeamSpan').html(game.maxUserPerTeam);
	$('.gameInfoInput').hide();
	$('#changeGameInfo a').html('');
	$('#changeGameInfo').append('(<a href="#changeGameInfo" onclick="editGameInfo()">edit</a>)');
	$('.gameInfoSpan').show();		
}

function createGame() {
	
	parameters = {};
	for (var i in game.items) {
		if (game.items[i] != null) {
			item = game.items[i];
			if (item instanceof Goal) {
				parameters['type_' + item.id] = 'GOA';
			}
			else {
				parameters['type_' + item.id] = 'HIN';
			}
//			alert(parameters['type_' + item.id]);
			parameters['itemId_' + item.id] = item.id;
			
			var lonlat = item.marker.lonlat.transform(
					new OpenLayers.Projection("EPSG:900913"), // to Spherical Mercator Projection
					new OpenLayers.Projection("EPSG:4326") // transform from WGS 1984
			);
			
			parameters['itemLatitude_' + item.id] = (lonlat.lat*1000000).toFixed(0);
//			alert(parameters['itemLatitude_' + item.id]);
			parameters['itemLongitude_' + item.id] = (lonlat.lon*1000000).toFixed(0);
//			alert(parameters['itemLongitude_' + item.id]);
			
			parameters['itemPoints_' + item.id] = item.points;
			parameters['itemName_' + item.id] = item.name;
			parameters['itemDescription_' + item.id] = item.description;
		}
	}
	parameters['city'] = game.city;
	parameters['latitude'] = (game.latitude*1000000).toFixed(0);
	parameters['longitude'] = (game.longitude*1000000).toFixed(0);
	parameters['maxTeams'] = game.maxTeams;
	parameters['maxUserPerTeam'] = game.maxUserPerTeam;
	parameters['numberOfItems'] = game.getItems().length;
	
	$.ajax({
		url : createURL,
		type : 'POST',
		data : parameters,
		success: parseResult
	});
}
function parseResult(data) {
	window.location = viewURL + data;
}
