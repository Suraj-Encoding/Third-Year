// # Dijkstra Algorithm
#include <bits/stdc++.h>
using namespace std;
const int N = 100;
const int INF = 1000;

vector<pair<int, int>> graph[N];
vector<int> Dijkstra(int source)
{
    vector<int> dist(N, INF);
    vector<bool> vis(N, false);
    set<pair<int, int>> s;
    s.insert({0, source});
    dist[source] = 0;
    while (s.size())
    {
        auto p = *s.begin();
        int v = p.second;
        int d = p.first;
        s.erase(s.begin());
        if (vis[v])
            continue;
        vis[v] = true;
        for (auto &child : graph[v])
        {
            int node = child.first;
            int wt = child.second;
            if (d + wt < dist[node])
            {
                dist[node] = d + wt;
                s.insert({dist[node], node});
            }
        }
    }
    return dist;
}

int main()
{
    int n, m;
    cin >> n >> m;
    for (int i = 0; i < m; i++)
    {
        int x, y, wt;
        cin >> x >> y >> wt;
        graph[x].push_back({y, wt});
    }
    int source;
    cin >> source;
    vector<int> distance = Dijkstra(source);
    for (int i = 0; i < n; i++)
    {
        cout << source << " --> " << i << " - " << distance[i] << endl;
    }
    return 0;
}