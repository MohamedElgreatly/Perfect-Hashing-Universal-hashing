Perfect Hashing
1 Overview
In this assignment, you’re required to implement a perfect hashing data structure. We say a hash function is perfect for S if all lookups involve O(1) work.
In section 2, background about universal hashing is provided. Sections 3 and 4 describe two methods for constructing perfect hash functions for a given set S. You’re required to design, analyze and implement a perfect hash table as described in sections 3 and 4.


2-- Universal Hashing
A probability distribution H over hash functions from U to {1, ..., M} is universal if for all
x = y in U, we have
P r[h(x) = h(y)] ≤ 1/M (1)


2.2-- Constructing a Universal Hash Family: the Matrix Method
Let’s say keys are u-bits long. Say the table size M is power of 2, so an index is b-bits long with M = 2^b. What we’ll do is pick h to be a random b-by-u 0/1 matrix, and define h(x) = hx, where we do addition mod 2. For instance:
We can show that for x = y, P r[h(x) = h(y)] = 1/M = 1/2^b


3-- O(N^2)-Space Solution
Say we are willing to have a table whose size is quadratic in the size N of our dictionary S. Then, here is an easy method. Let H be universal and M = N^2. Pick a random h from H and try it out, hashing everything in S. So, we just try it, and if we got any collisions, we just try a new h. On average, we will only need to do this twice.


4-- O(N)-Space Solution
The main idea for this method is to use universal hash functions in a 2-level scheme.
The method is as follows. We will first hash into a table of size N using universal hashing. This will produce some collisions. However, we will then rehash each bin using Method 1, squaring the size of the bin to get zero collisions. So, the way to think of this scheme is that we have a first-level hash function h and first-level table A, and then N second-level hash functions h1, ..., hN and N second-level tables A1, ..., AN . To lookup an element x, we first compute i = h(x) and then find the element in Ai[hi(x)].

5-- Requirements
You’re required to:
1. Implement an O(N2) as well as an O(N)-Space perfect hash table implemented as de- scribed in sections 3 and 4.
2. Verify that the hash table you constructed consumes O(N2)-space in the the quadratic space method and O(N)-space in the linear space method.
3. Report the number of times required to re-build the hash table in the case of collision.
4. Deliver a report describing your implementation details.
You may assume that the keys will all be 32-bit integers
5. Works in teams of 2
