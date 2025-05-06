Feature:

@Child-Network
Scenario: OCN_12: Submit Onboarding Request with Network Name, Wallet and Multiple Nodes
    Given the user is signed in
  Then the user clicks "Get Started" button
    And the user is on the Child Launch Network page
    When the user enters network name "NetworkName-01"
    And the user enters wallet address "0x88fa61d2faA13aad8Fbd5B030372B4A159BbbDFb"
    And the user clicks "Next" button
    And the user adds the following nodes:
      | node_id     | public_ip     |
      | NodeID-001  | 192.168.0.1   |
      | NodeID-002  | 192.168.0.2   |
      | NodeID-003  | 10.0.0.1      |
    And the user clicks "Next" button
    Then the user should see the summary of entered network, wallet
    Then the user should see the following nodes in the summary:
     | node_id    |
     | NodeID-001 |
     | NodeID-002 |
     | NodeID-003 |
    When the user clicks "Submit" button

