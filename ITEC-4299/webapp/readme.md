# Troubleshooting from outdated tutorial

https://www.youtube.com/watch?v=0UG2x2iWerk tutorial uses build which will not allow docker desktop to see images, builds, or containers build via cli given installation as directed in earlier part of assignment.

## Solution

    Use docker buildx build <dir> -t <tag-name>
