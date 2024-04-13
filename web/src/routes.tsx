import { BrowserRouter, Route, Routes as ReactRoutes } from 'react-router-dom';

import { Landing } from "./pages/landing";
import { OrphanagesMap } from "./pages/orphanages-map";

export const Routes = () => {
  return (
    <BrowserRouter>
      <ReactRoutes>
        <Route path="/" element={<Landing />} />
        <Route path="/app" element={<OrphanagesMap />} />
      </ReactRoutes>
    </BrowserRouter>
  )
} 