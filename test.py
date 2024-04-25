
A = {('x1', 'y1'): 0.7, ('x1', 'y2'): 0.5, ('x2', 'y1'): 0.8, ('x2', 'y2'): 0.4 }
B = {('y1', 'z1'): 0.9, ('y1', 'z2'): 0.6, ('y2', 'z1'): 0.1, ('y2', 'z2'): 0.7 }

def minMax(A, B):
    result = {}
    for (x, y), r_val in A.items():
       for (y_prime, z), s_val in B.items():
           if y == y_prime:
                if(x, z) not in result:
                   result[(x, z)] = r_val if r_val < s_val else s_val
                else:
                    result[(x, z)] = max(result[(x, z)], min(r_val, s_val))
                #  else:
    return result

print(minMax(A, B)) 