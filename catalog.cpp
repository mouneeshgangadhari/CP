#include <iostream>
#include <vector>
#include <map>
#include <cmath>
#include "json.hpp"

using json = nlohmann::json;

// Function to calculate modular inverse
int modInverse(int a, int m) {
    a = a % m;
    for (int x = 1; x < m; x++)
        if ((a * x) % m == 1)
            return x;
    return -1;
}

// Function to calculate polynomial interpolation using Lagrange's interpolation
int interpolate(std::map<int, int>& shares, int prime) {
    int result = 0;
    for (auto const& share : shares) {
        int term = share.second;
        for (auto const& otherShare : shares) {
            if (otherShare.first != share.first) {
                int numerator = -otherShare.first;
                int denominator = share.first - otherShare.first;
                term = (term * numerator * modInverse(denominator, prime)) % prime;
            }
        }
        result = (result + term + prime) % prime;
    }
    return result;
}

int main() {
    // Read input from JSON
    std::ifstream file("input.json");
    json input;
    file >> input;

    int n = input["keys"]["n"];
    int k = input["keys"]["k"];
    int prime = 257; // Prime number chosen arbitrarily

    // Initialize shares map
    std::map<int, int> shares;

    // Iterate through shares in input JSON
    for (int i = 1; i <= n; ++i) {
        std::string base = input[std::to_string(i)]["base"];
        std::string value = input[std::to_string(i)]["value"];
        int baseInt = std::stoi(base);
        int valueInt = std::stoi(value, 0, baseInt);
        shares[i] = valueInt;
    }

    // Ensure we have enough shares to reconstruct the secret
    if (shares.size() < k) {
        std::cout << "Not enough shares to reconstruct the secret." << std::endl;
        return 1;
    }

    // Reconstruct the secret
    int secret = interpolate(shares, prime);

    std::cout << "The reconstructed secret is: " << secret << std::endl;

    return 0;
}

