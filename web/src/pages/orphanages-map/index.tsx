import { Link } from "react-router-dom";
import { FiPlus, FiArrowRight } from "react-icons/fi";

import { MapContainer as Map, TileLayer as Layer, Marker, Popup } from 'react-leaflet';
import Leaflet from "leaflet";

import 'leaflet/dist/leaflet.css';
import './styles.css';

import { assets } from "../../assets";

const markerIcon = Leaflet.icon({
  iconUrl: assets.IMG_MAP_MARKER,
  iconSize: [58, 68],
  iconAnchor: [29, 68],
  popupAnchor: [170, 2],
});

export const OrphanagesMap = () => {
  return (
    <div id="page-map">
      <aside>
        <header>
          <img src={assets.IMG_MAP_MARKER} alt="Happy" />

          <h2>Escolha um orfanato no mapa</h2>
          <p>Muitas crianças estão esperando a sua visita :)</p>
        </header>

        <footer>
          <strong>Londrina</strong>
          <span>Paraná</span>
        </footer>
      </aside>

      <Map center={[-23.2995497, -51.1814481]} zoom={13} style={{ width: '100%', height: '100%' }}>
        <Layer url="https://a.tile.openstreetmap.org/{z}/{x}/{y}.png" />
        <Marker
          position={[-23.2995497, -51.1814481]}
          icon={markerIcon}
        >
          <Popup
            closeButton={false}
            minWidth={240}
            maxWidth={240}
            className="map-popup"
          >
            Orfanato com um...
            <Link to="a">
              <FiArrowRight size={20} color="#fff" />
            </Link>
          </Popup>
        </Marker>
      </Map>

      <Link to="/create-orphanage" className="create-orphanage">
        <FiPlus size={32} color="#fff" />
      </Link>
    </div>
  )
}