package com.kichou.imad.instgramprofileui


import androidx.annotation.DrawableRes
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon

import androidx.compose.material3.Scaffold
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
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
    var selectedTabIndex by remember {
        mutableStateOf(0)
    }
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

            FunctionalitySection()

            StorySection(listOf(

                StoryItem(storyTitle = "YouTube",
                    storyIcon = R.drawable.youtube),

                StoryItem(storyTitle = "Q&A",
                    storyIcon = R.drawable.qa),

                StoryItem(storyTitle = "Discord",
                    storyIcon = R.drawable.discord),

                StoryItem(storyTitle = "Telegram",
                    storyIcon = R.drawable.telegram),

            ))


            PostTabView(
                imageWithTexts = listOf(
                    ImageWithText(
                        image = painterResource(id = R.drawable.ic_grid),
                        text = "Posts"
                    ),
                    ImageWithText(
                        image = painterResource(id = R.drawable.ic_reels),
                        text = "Reels"
                    ),
                    ImageWithText(
                        image = painterResource(id = R.drawable.ic_igtv),
                        text = "IGTV"
                    ),
                    ImageWithText(
                        image = painterResource(id = R.drawable.profile),
                        text = "Profile"
                    ),
                )
            ) {
                selectedTabIndex = it
            }
            when(selectedTabIndex) {
                0 -> PostSection(
                    posts = listOf(
                        painterResource(id = R.drawable.kmm),
                        painterResource(id = R.drawable.intermediate_dev),
                        painterResource(id = R.drawable.master_logical_thinking),
                        painterResource(id = R.drawable.bad_habits),
                        painterResource(id = R.drawable.multiple_languages),
                        painterResource(id = R.drawable.learn_coding_fast),
                    ),
                    modifier = Modifier.fillMaxWidth()
                )
            }
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


@Composable
fun FunctionalitySection(){

    Row (modifier = Modifier
        .fillMaxWidth()
        .padding(vertical = 10.dp, horizontal = 20.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween){

        Button(onClick = { /*TODO*/ },
            shape = RoundedCornerShape(15),
            border = BorderStroke(width = 1.dp, color = Color.Gray)) {


                Text(text = "Following",
                    style = TextStyle(
                        fontSize = 13.sp,
                        fontWeight = FontWeight.ExtraBold
                    ),
                    color = Color.Black)

                Icon(
                    imageVector =Icons.Default.ArrowDropDown,
                    contentDescription = "drop_down_arrow",
                    modifier = Modifier.size(15.dp),
                    tint = Color.Black
                )


        }

        //

        Button(onClick = { /*TODO*/ },
            shape = RoundedCornerShape(15),
            border = BorderStroke(width = 1.dp, color = Color.Gray))  {


                Text(text = "Messages",
                    style = TextStyle(
                        fontSize = 13.sp,
                        fontWeight = FontWeight.ExtraBold
                    ),
                    color = Color.Black)



        }

        Button(onClick = { /*TODO*/ },
            shape = RoundedCornerShape(15),
            border = BorderStroke(width = 1.dp, color = Color.Gray)
        )  {

                Text(text = "Email",
                    style = TextStyle(
                        fontSize = 13.sp,
                        fontWeight = FontWeight.ExtraBold
                    ),
                    color = Color.Black)

        }



    }

}



@Composable
fun StorySection(stories : List<StoryItem>){

    LazyRow(modifier = Modifier
        .fillMaxWidth()
        .padding(vertical = 10.dp, horizontal = 20.dp)){

        items(stories.size){

            Column (modifier = Modifier.padding(end = 5.dp),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally){


                Image(painter = painterResource(stories[it].storyIcon),
                    contentDescription = stories[it].storyTitle,
                    modifier = Modifier
                        .size(80.dp)
                        .clip(shape = CircleShape))

                Text(text = stories[it].storyTitle,
                    style = TextStyle(
                        fontWeight = FontWeight.Medium,
                        fontSize = 15.sp
                    ),
                    color = Color.Black,
                    modifier = Modifier.padding(top = 5.dp)
                )


            }

        }
    }


}



@Composable
fun PostTabView(
    modifier: Modifier = Modifier,
    imageWithTexts: List<ImageWithText>,
    onTabSelected: (selectedIndex: Int) -> Unit
) {
    var selectedTabIndex by remember {
        mutableStateOf(0)
    }
    val inactiveColor = Color(0xFF777777)
    TabRow(
        selectedTabIndex = selectedTabIndex,
        containerColor = Color.Transparent,
        contentColor = Color.Black,
        modifier = modifier
    ) {
        imageWithTexts.forEachIndexed { index, item ->
            Tab(
                selected = selectedTabIndex == index,
                selectedContentColor = Color.Black,
                unselectedContentColor = inactiveColor,
                onClick = {
                    selectedTabIndex = index
                    onTabSelected(index)
                }
            ) {
                Icon(
                    painter = item.image,
                    contentDescription = item.text,
                    tint = if(selectedTabIndex == index) Color.Black else inactiveColor,
                    modifier = Modifier
                        .padding(10.dp)
                        .size(20.dp)
                )
            }
        }
    }
}


@Composable
fun PostSection(
    posts: List<Painter>,
    modifier: Modifier = Modifier
) {
    LazyVerticalGrid(
        columns = GridCells.Fixed(3),
        modifier = modifier
            .scale(1.01f)
    ) {
        items(posts.size) {
            Image(
                painter = posts[it],
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .aspectRatio(1f)
                    .border(
                        width = 1.dp,
                        color = Color.White
                    )
            )
        }
    }
}