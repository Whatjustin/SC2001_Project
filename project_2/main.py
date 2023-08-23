import networkx as nx
import matplotlib.pyplot as plt

G = nx.gnp_random_graph(100, 0.9, 10, True)

print(G)