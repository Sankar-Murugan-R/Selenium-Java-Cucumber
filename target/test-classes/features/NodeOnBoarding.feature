@Node-Onboard
Feature: Onboarding Request with Nodes and Wallets

  Scenario: OCN_12: Submit Onboarding Request with Multiple Nodes and Wallets
    Given the user is signed in
    Then the user clicks "Get Started" button
    Given the user is on the Node Onboarding page
    When the user adds the following nodes:
      | node_id      | public_ip     |
      | NodeID-001   | 192.168.1.1   |
      | NodeID-002   | 193.16.10.2   |
      | NodeID-003   | 174.19.1.16   |
      | NodeID-004   | 192.168.1.2   |
      | NodeID-005   | 192.168.1.1   |
      | NodeID-006   | 192.168.1.2   |
    And the user clicks "Next" button
    And the user adds the following wallets:
      | wallet_address                                   | permission             |
      | 0x88fa61d2faA13aad8Fbd5B030372B4A159BbbDFb       | Transaction Submission |
    And the user clicks "Next" button
    Then the user should see the following nodes in the summary:
      | node_id    |
      | NodeID-001 |
      | NodeID-002 |
      | NodeID-003 |
      | NodeID-004 |
      | NodeID-005 |
      | NodeID-006 |

    And the user should see the following wallet addresses in the summary:
      | wallet_address                               |
      | 0x88fa61d2faA13aad8Fbd5B030372B4A159BbbDFb   |
    When the user clicks "Submit" button

