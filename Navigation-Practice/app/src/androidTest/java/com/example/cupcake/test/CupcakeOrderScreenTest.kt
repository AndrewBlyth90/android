package com.example.cupcake.test

import androidx.activity.ComponentActivity
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.assertIsNotEnabled
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.test.onNodeWithContentDescription
import androidx.compose.ui.test.onNodeWithText
import com.example.cupcake.R
import com.example.cupcake.data.DataSource
import com.example.cupcake.data.OrderUiState
import com.example.cupcake.ui.OrderSummaryScreen
import com.example.cupcake.ui.SelectOptionScreen
import com.example.cupcake.ui.StartOrderScreen
import org.junit.Rule
import org.junit.Test

class CupcakeOrderScreenTest {

        @get:Rule
        val composeTestRule = createAndroidComposeRule<ComponentActivity>()

        @Test
        fun selectOptionScreen_verifyContent() {
            val flavors = listOf("Vanilla", "Chocolate", "Hazelnut", "Cookie", "Mango")
            val subtotal = "$100"

            composeTestRule.setContent {
                SelectOptionScreen(subtotal = subtotal, options = flavors)
            }

            flavors.forEach { flavor ->
                composeTestRule.onNodeWithText(flavor).assertIsDisplayed()
            }

            composeTestRule.onNodeWithText(
                composeTestRule.activity.getString(
                    R.string.subtotal_price,
                    subtotal
                )
            ).assertIsDisplayed()

            composeTestRule.onNodeWithStringId(R.string.next).assertIsNotEnabled()
        }

        @Test
        fun startScreen_verifyContent(){

            composeTestRule.setContent {
                StartOrderScreen(
                    quantityOptions = DataSource.quantityOptions,
                    onNextButtonClicked = {}
                )
            }

            DataSource.quantityOptions.forEach {
                composeTestRule.onNodeWithStringId(it.first).assertIsDisplayed()
            }
        }

        @Test
        fun summaryScreen_verifyContent(){

            val quantity = 0
            val flavour = "flavour"
            val date = "date"
            val price = "price"

            val mockUiState = OrderUiState(quantity = quantity, flavor = flavour, date = date, price = price)




            composeTestRule.setContent {
                OrderSummaryScreen(
                    onCancelButtonClicked = {},
                    orderUiState = mockUiState,
                    onSendButtonClicked = { _: String, _: String -> }
                )
            }

            composeTestRule.onNodeWithText(flavour).assertIsDisplayed()
            composeTestRule.onNodeWithText(date).assertIsDisplayed()
            composeTestRule.onNodeWithText(
                composeTestRule.activity.getString(
                    R.string.subtotal_price,
                    mockUiState.price
                )
            ).assertIsDisplayed()
        }

    }
