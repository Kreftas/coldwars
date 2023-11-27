/*
 * Copyright (c) Axis Communications AB, SWEDEN. All rights reserved.
 */

package presentation.card

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import model.data.BasicCard
import ui.CardDimension
import ui.clickableOrNot

@Composable
fun ColumnScope.CardImageTitle(
  basicCard: BasicCard,
  cardDimension: CardDimension = CardDimension.Medium,
  onClick: (() -> Unit)? = null,
) {
  val imageHeight = if (cardDimension !is CardDimension.Small) .4f else .7f

  Box(
    contentAlignment = Alignment.TopCenter,
    modifier = Modifier
      .clip(RoundedCornerShape(8.dp, 8.dp, 0.dp, 0.dp))
      .fillMaxWidth()
      .fillMaxHeight(imageHeight)
      .clickableOrNot(onClick)
  ) {
    Image(
      painter = painterResource(basicCard.imageRes),
      contentDescription = null
    )
  }
  Spacer(Modifier.height(4.dp))
}