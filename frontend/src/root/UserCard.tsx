// UserCard.tsx
import React from 'react';
import { Card, CardContent, Typography } from '@mui/material';

interface UserCardProps {
  name: string;
  email: string;
  username: string;
}

const UserCard: React.FC<UserCardProps> = ({ name, email, username }) => (
  <Card sx={{ maxWidth: 300}}>
    <CardContent>
      <Typography variant="h6" component="div" gutterBottom>
        {name}
      </Typography>
      <Typography variant="body2" color="text.secondary">
        @{username}
      </Typography>
      <Typography variant="body2" color="text.secondary">
        {email}
      </Typography>
    </CardContent>
  </Card>
);

export default UserCard;
