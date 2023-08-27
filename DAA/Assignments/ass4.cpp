// # Assignment-4 : Dijkstra Algorithm
// # Network Delay Time Problem
// # Time : O(V + ElogV)
#include <bits/stdc++.h>
using namespace std;
const int N = 1e5;
const int INF = 1e9;

vector<pair<int, int>> graph[N];
int Dijkstra(int source, int n)
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
    int ans = 0;
    for (int i = 1; i <= n; i++)
    {
        if (dist[i] == INF)
            return -1;
        ans = max(ans, dist[i]);
    }
    return ans;
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
    int ans = Dijkstra(source, n);
    cout << "\nTime: " << ans << endl;
    if (ans == -1)
        cout << "Impossible" << endl;
    return 0;
}