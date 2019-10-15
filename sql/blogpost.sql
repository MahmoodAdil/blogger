
-- --------------------------------------------------------

--
-- Table structure for table `blog-post`
--
CREATE TABLE public."blogpost"
(
    "blogid" serial NOT NULL,
    "blogtitle" character varying(199) NOT NULL,
    "blogcontents" text NOT NULL,
    "postdate" timestamp with time zone,
    PRIMARY KEY ("blogid")
)
WITH (
    OIDS = FALSE
);

ALTER TABLE public."blog-post"
    OWNER to postgres;
    

INSERT INTO public."blog-post"(
	"blogid", "blogtitle", "blogcontents", "postdate")
	VALUES (1, 'Java 11 HttpClient Examples', 'This article shows you how to use the new Java 11 HttpClient APIs to send HTTP GET/POST requests, and some frequent used examples.', '2017-08-19 02:22:11.802755-10');



INSERT INTO public."blog-post"(
	"blog-id", "blog-title", "blog-contents", "post-date")
	VALUES (2, 'Java – How to get keys and values from Map', 'This article shows you how to use the Java – How to get keys and values from Map.', '2019-08-19 02:22:11.802755-10');


