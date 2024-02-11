import { Grid, Typography } from '@mui/material';
import { TextField } from '@mui/material';

const SignupForm = () => {
  return (
    <>
      <Grid container direction="column" spacing={4} alignItems="center">
        <Grid item md={4}>
          <Typography variant="h4">Create a new account</Typography>
          <Typography variant="caption">To use snapgram, Please enter your details</Typography>
        </Grid>

        <Grid item container md={8} direction="column">
          <TextField id="name" type="text" label="Name" margin="normal" autoComplete="off"/>
          <TextField id="username" type="text" label="Username" margin="normal" autoComplete="off"/>
          <TextField id="email" type="email" label="Email" margin="normal" autoComplete="off"/>
          <TextField id="password" type="password" label="Password" margin="normal" autoComplete="off"/>
        </Grid>
      </Grid>
    </>
    
  )
}

export default SignupForm