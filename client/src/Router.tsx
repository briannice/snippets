import Layout from '@/layouts/Layout'
import Home from '@/pages/Home'
import { Route, Routes } from 'react-router-dom'

function Router() {
  return (
    <Routes>
      <Route element={<Layout />}>
        <Route path="/" element={<Home />} />
      </Route>
    </Routes>
  )
}

export default Router
