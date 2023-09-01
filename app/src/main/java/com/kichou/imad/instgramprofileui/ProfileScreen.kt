package com.kichou.imad.instgramprofileui


import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon

import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.SpanStyle

import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp



@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProfileScreen()
{
    Scaffold (
        modifier = Modifier
            .fillMaxSize(),
        topBar = { ProfileTopAppBar(profileName = "Imad_E") }){

        Column (modifier = Modifier
            .fillMaxWidth()
            .padding(it)){


            ProfileStatSection(
                profileIcon = {
                    Image(
                        painter = painterResource(id = R.drawable.profile_pic),
                        contentDescription = "Profile_pic",
                        modifier = Modifier
                            .size(80.dp)
                            .clip(shape = CircleShape)
                    )
                },
                profilePostNumber = 800,
                profileFollowersNumber = 200,
                profileFollowingNumber = 190
            )


            ProfileBioSection(
                bioTitle = "Programming Mentor",
                bioDescription = "Android Developer\n5 Years Of experience\nDrop Table",
                followingList = listOf("Imad_K","Youcef_2"),
                otherFollowersNumber = 17
            )



        }



    }
}



@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProfileTopAppBar(
    modifier : Modifier = Modifier,
    profileName : String){


    TopAppBar(
        modifier = modifier,
        title = {
            Text(text = profileName,
                style = TextStyle(
                    fontWeight = FontWeight.Bold,
                    fontSize = 22.sp
                ),
                color = Color.Black,
                modifier = Modifier.padding(start = 8.dp),
                overflow = TextOverflow.Ellipsis)
        },
        navigationIcon = {
           Icon(
               imageVector =Icons.Default.ArrowBack,
               contentDescription = "Arrow_back",
               modifier = Modifier
                   .size(40.dp)
                   .padding(5.dp),
               tint = Color.Black
           )
        },
        actions = {
            Icon(
                imageVector = Icons.Default.Notifications,
                contentDescription = "notification button",
                modifier = Modifier
                    .size(40.dp)
                    .padding(5.dp),
                tint = Color.Black
            )
            Icon(
                imageVector = Icons.Default.MoreVert,
                contentDescription = "more button",
                modifier = Modifier
                    .size(40.dp)
                    .padding(5.dp),
                tint = Color.Black
            )
        })

}


@Composable
fun ProfileStatSection(

    modifier: Modifier = Modifier,
    profileIcon : @Composable () ->Unit,
    profilePostNumber : Int,
    profileFollowersNumber: Int,
    profileFollowingNumber : Int){

    Row (modifier = modifier
        .fillMaxWidth()
        .padding(vertical = 5.dp, horizontal = 20.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween){

        profileIcon()

        Column (
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally){

            Text(text = profilePostNumber.toString(),
                style = TextStyle(
                    fontWeight = FontWeight.Bold,
                    fontSize = 18.sp),
                color = Color.Black)

            Text(text = "Posts",
                style = TextStyle(
                    fontWeight = FontWeight.Medium,
                    fontSize = 14.sp),
                color = Color.Black)

        }

        //


        Column (
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally){

            Text(text = profileFollowersNumber.toString(),
                style = TextStyle(
                    fontWeight = FontWeight.Bold,
                    fontSize = 18.sp),
                color = Color.Black)

            Text(text = "Followers",
                style = TextStyle(
                    fontWeight = FontWeight.Medium,
                    fontSize = 14.sp),
                color = Color.Black)

        }

        //


        Column (
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally){

            Text(text = profileFollowingNumber.toString(),
                style = TextStyle(
                    fontWeight = FontWeight.Bold,
                    fontSize = 18.sp),
                color = Color.Black)

            Text(text = "Following",
                style = TextStyle(
                    fontWeight = FontWeight.Medium,
                    fontSize = 14.sp),
                color = Color.Black)

        }



    }




}



@Composable
fun ProfileBioSection(

    bioTitle : String,
    bioDescription: String,
    followingList : List<String>,
    otherFollowersNumber :Int){

    Column (modifier = Modifier
        .fillMaxWidth()
        .padding(vertical = 10.dp, horizontal = 20.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.Start){

        Text(text = bioTitle,
            style = TextStyle(
                fontWeight = FontWeight.Bold,
                fontSize = 16.sp
            ),
            color = Color.Black
        )
        Text(text = bioDescription,
            style = TextStyle(
                fontWeight = FontWeight.Medium,
                fontSize = 15.sp
            ),
            color = Color.Black,
            maxLines = 6
        )

        Text(buildAnnotatedString {
            withStyle(style = SpanStyle(
                fontWeight = FontWeight.Medium,
                fontSize = 15.sp,
                color = Color.Black)){
                append("Following")
            }

            withStyle(style = SpanStyle(
                fontWeight = FontWeight.Bold,
                fontSize = 15.sp,
                color = Color.Black)){

                var stringToAppend = ""
                followingList.forEach {
                    stringToAppend += " $it,"
                }
                stringToAppend = stringToAppend.dropLast(1)
                append(stringToAppend)
            }

            withStyle(style = SpanStyle(
                fontWeight = FontWeight.Medium,
                fontSize = 15.sp,
                color = Color.Black)){
                append(" and")
            }

            withStyle(style = SpanStyle(
                fontWeight = FontWeight.Bold,
                fontSize = 15.sp,
                color = Color.Black)){
                append(" $otherFollowersNumber others")
            }



        })


    }




}


