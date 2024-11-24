import React, { useState, useEffect } from 'react';
import Post from './Post';
import { PostType } from '../types';
import { Box, CircularProgress, Container, Grid, Typography, useMediaQuery, useTheme } from '@mui/material';
import UserCard from './UserCard';

const Posts = () => {
  const [posts, setPosts] = useState<PostType[]>([]);
  const [users, setUsers] = useState<any[]>([]); // User data 
  const [loading, setLoading] = useState(true);

  const theme = useTheme();
  const isMobile = useMediaQuery(theme.breakpoints.down('sm'));

  // Fetch posts from an API
  useEffect(() => {
    fetch('https://jsonplaceholder.typicode.com/posts')
      .then(response => response.json())
      .then(data => {
        setPosts(data);
      })
      .catch(error => {
        console.error("Error fetching posts:", error);
      });
    
      // Fetch users
      fetch('https://jsonplaceholder.typicode.com/users')
        .then((response) => response.json())
        .then((data) => {
          setUsers(data);
        })
        .catch((error) => {
          console.error('Error fetching users:', error);
        })
        .finally(() => setLoading(false));
  }, []);

  if (loading) return <CircularProgress sx={{ margin: '50px auto', display: 'block' }} />;

  return (
    <Box sx={{ display: 'flex', justifyContent: 'space-between', padding: '16px' }}>
    {/* Left Section for Posts */}
    <Box sx={{ flex: 1 }}>
      <Container maxWidth="md">
        <Typography variant="h4" component="h1" gutterBottom align="center">
          Posts
        </Typography>
        {posts.map((post) => (
          <Post key={post.id} title={post.title} body={post.body} />
        ))}
      </Container>
    </Box>

    {/* Right Section for User Cards */}
    {!isMobile && <Box sx={{ width: '500px', paddingLeft: '20px' }}>
      <Typography variant="h6" component="h2" gutterBottom align="center">
        Users
      </Typography>
      <Grid container spacing={2} justifyContent="flex-start">
          {users.map((user) => (
            <Grid item xs={12} sm={12} md={6} key={user.id}>
              <UserCard name={user.name} email={user.email} username={user.username} />
            </Grid>
          ))}
        </Grid>
    </Box>
    }
  </Box>
  );
};

export default Posts;
