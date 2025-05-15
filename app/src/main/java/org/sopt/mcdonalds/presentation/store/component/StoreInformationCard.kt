package org.sopt.mcdonalds.presentation.store.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import org.sopt.mcdonalds.R.drawable.ic_close_24
import org.sopt.mcdonalds.R.drawable.ic_right_chevron
import org.sopt.mcdonalds.R.string.select_store
import org.sopt.mcdonalds.R.string.store_address
import org.sopt.mcdonalds.R.string.store_congestion_high
import org.sopt.mcdonalds.R.string.store_information
import org.sopt.mcdonalds.R.string.store_location_information
import org.sopt.mcdonalds.R.string.store_open_hours
import org.sopt.mcdonalds.core.designsystem.theme.MCDONALDSTheme
import org.sopt.mcdonalds.core.designsystem.theme.McDonaldsTheme

@Composable
fun StoreInformationCard(
    isBusy: Boolean,
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier.shadow(4.dp),
        shape = RoundedCornerShape(8.dp),
        colors = CardDefaults.cardColors().copy(
            containerColor = McDonaldsTheme.colors.white
        )
    ) {
        Column(
            modifier = Modifier
                .padding(top = 16.dp, start = 16.dp, end = 16.dp, bottom = 12.dp)
        ) {
            Row(
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                if (isBusy) {
                    Text(
                        text = stringResource(store_congestion_high),
                        style = McDonaldsTheme.typography.body12r.copy(
                            color = McDonaldsTheme.colors.red
                        ),
                        modifier = Modifier
                            .background(
                                color = McDonaldsTheme.colors.lightRed,
                                shape = RoundedCornerShape(4.dp)
                            ).padding(horizontal = 8.dp)
                    )
                }

                Spacer(modifier = Modifier.weight(1f))

                Icon(
                    imageVector = ImageVector.vectorResource(ic_close_24),
                    contentDescription = null,
                    tint = McDonaldsTheme.colors.black
                )
            }

            Text(
                text = stringResource(store_location_information),
                style = McDonaldsTheme.typography.body14b.copy(
                    color = McDonaldsTheme.colors.black
                )
            )

            Spacer(modifier = Modifier.height(4.dp))

            Text(
                text = stringResource(store_address),
                style = McDonaldsTheme.typography.body12r.copy(
                    color = McDonaldsTheme.colors.gray600
                )
            )

            Text(
                text = stringResource(store_open_hours),
                style = McDonaldsTheme.typography.body12r.copy(
                    color = McDonaldsTheme.colors.gray800
                )
            )

            Spacer(modifier = Modifier.height(4.dp))

            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = stringResource(store_information),
                    style = McDonaldsTheme.typography.body12r.copy(
                        color = McDonaldsTheme.colors.gray700
                    )
                )

                Icon(
                    imageVector = ImageVector.vectorResource(ic_right_chevron),
                    contentDescription = null,
                    tint = McDonaldsTheme.colors.gray600
                )
            }
        }

        Box(
            modifier = Modifier
                .padding(start = 12.dp, end = 12.dp, bottom = 16.dp)
                .fillMaxWidth()
                .background(
                    color = McDonaldsTheme.colors.yellow,
                    shape = RoundedCornerShape(4.dp)
                )
                .padding(vertical = 12.dp),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = stringResource(select_store),
                style = McDonaldsTheme.typography.body14r.copy(
                    color = McDonaldsTheme.colors.gray800
                )
            )
        }
    }
}

@Preview
@Composable
private fun StoreInformationCardPreview() {
    MCDONALDSTheme {
        Column {
            StoreInformationCard(
                isBusy = true
            )
            StoreInformationCard(
                isBusy = false
            )
        }
    }
}
