import React from 'react'
import { Outlet, Navigate } from 'react-router-dom';
import { Grid } from '@mui/material';

const AuthLayout = () => {
  const isAuthenticated = false;
  return (
    <>
      {isAuthenticated ? (
        <Navigate to = "/" />
      ) : (
        // <>
          <Grid container alignItems="center" justifyContent="space-between">
            <Grid item container md={6} direction="column" alignItems="center" spacing={3}>
              <Grid item md={1}>
                <img 
                  src="/assets/images/logo.svg" 
                  alt="snapgram logo"
                />
              </Grid>

              <Grid item md={8}> 
                <section>
                  <Outlet/>
                </section>
              </Grid>
            </Grid>
              <Grid item sx={{ display: { xs: 'none', md: 'block' } }}>
                  <img 
                    src="/assets/images/side-img.svg" 
                    alt="auth side screen"
                    className="h-screen"
                  />
              </Grid>
          </Grid>
        // </>
        
      )}
    </>
  )
}

export default AuthLayout
