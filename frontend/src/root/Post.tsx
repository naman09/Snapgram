import React from 'react';
import { Card, CardContent, Typography } from '@mui/material';

interface PostProps {
    title: string;
    body: string;
}

const Post: React.FC<PostProps> = ({ title, body }) => (
    <Card sx={{ maxWidth: 500, margin: '16px auto', padding: '16px', boxShadow: 3 }}>
    <CardContent>
      <Typography variant="h5" component="div" gutterBottom>
        {title}
      </Typography>
      <Typography variant="body2" color="text.secondary">
        {body}
      </Typography>
    </CardContent>
  </Card>
);

export default Post;
